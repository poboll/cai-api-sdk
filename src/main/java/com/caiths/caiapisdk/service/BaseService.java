package com.caiths.caiapisdk.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.caiths.caiapisdk.client.CaiApiClient;
import com.caiths.caiapisdk.exception.ApiException;
import com.caiths.caiapisdk.exception.ErrorCode;
import com.caiths.caiapisdk.exception.ErrorResponse;
import com.caiths.caiapisdk.model.request.BaseRequest;
import com.caiths.caiapisdk.model.response.ResultResponse;
import com.caiths.caiapisdk.utils.SignUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * BaseService 类，提供与 API 服务交互的基础方法。
 * <p>
 * 包括配置检查、请求执行、响应处理及请求头生成等通用功能的实现。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Slf4j
@Data
public abstract class BaseService implements ApiService {
    private CaiApiClient caiApiClient;

    /**
     * 网关HOST
     */
    private String gatewayHost = "https://apigw.caiths.com/api";

    /**
     * 检查配置
     *
     * @param caiApiClient CaiApiClient 客户端
     * @throws ApiException 如果配置无效则抛出业务异常
     */
    public void checkConfig(CaiApiClient caiApiClient) throws ApiException {
        if (caiApiClient == null && this.getCaiApiClient() == null) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }
        if (caiApiClient != null && !StringUtils.isAnyBlank(caiApiClient.getAccessKey(), caiApiClient.getSecretKey())) {
            this.setCaiApiClient(caiApiClient);
        }
    }

    /**
     * 执行请求
     *
     * @param request 请求参数
     * @return {@link HttpResponse} HTTP 响应
     * @throws ApiException 如果请求过程中发生异常则抛出
     */
    private <O, T extends ResultResponse> HttpResponse doRequest(BaseRequest<O, T> request) throws ApiException {
        try (HttpResponse httpResponse = getHttpRequestByRequestMethod(request).execute()) {
            return httpResponse;
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    /**
     * 通过请求方法获取 HTTP 请求对象
     *
     * @param request 请求参数
     * @return {@link HttpRequest} HTTP 请求对象
     * @throws ApiException 如果请求参数无效或不支持的请求方法则抛出
     */
    private <O, T extends ResultResponse> HttpRequest getHttpRequestByRequestMethod(BaseRequest<O, T> request) throws ApiException {
        if (ObjectUtils.isEmpty(request)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求参数错误");
        }
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();

        if (ObjectUtils.isEmpty(method)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求方法不存在");
        }
        if (StringUtils.isBlank(path)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求路径不存在");
        }

        if (path.startsWith(gatewayHost)) {
            path = path.substring(gatewayHost.length());
        }
        log.info("请求方法：{}，请求路径：{}，请求参数：{}", method, path, request.getRequestParams());
        HttpRequest httpRequest;
        switch (method) {
            case "GET": {
                httpRequest = HttpRequest.get(splicingGetRequest(request, path));
                break;
            }
            case "POST": {
                httpRequest = HttpRequest.post(gatewayHost + path);
                break;
            }
            default: {
                throw new ApiException(ErrorCode.OPERATION_ERROR, "不支持该请求");
            }
        }
        return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request), caiApiClient)).body(JSONUtil.toJsonStr(request.getRequestParams()));
    }

    /**
     * 获取响应数据并解析
     *
     * @param request 请求参数，包含请求路径、请求方法和请求参数
     * @param <O>     请求参数的类型
     * @param <T>     响应数据的类型，必须继承 {@link ResultResponse}
     * @return {@link T} 泛型结果对象
     * @throws ApiException 如果解析失败或响应错误则抛出
     */
    public <O, T extends ResultResponse> T res(BaseRequest<O, T> request) throws ApiException {
        if (caiApiClient == null || StringUtils.isAnyBlank(caiApiClient.getAccessKey(), caiApiClient.getSecretKey())) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }
        T rsp;
        try {
            Class<T> clazz = request.getResponseClass();
            rsp = clazz.newInstance();
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
        HttpResponse httpResponse = doRequest(request);
        String body = httpResponse.body();
        Map<String, Object> data = new HashMap<>();
        if (httpResponse.getStatus() != 200) {
            ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
            data.put("errorMessage", errorResponse.getMessage());
            data.put("code", errorResponse.getCode());
        } else {
            try {
                data = new Gson().fromJson(body, new TypeToken<Map<String, Object>>() {
                }.getType());
            } catch (JsonSyntaxException e) {
                data.put("value", body);
            }
        }
        rsp.setData(data);
        return rsp;
    }

    /**
     * 拼接 GET 请求的 URL
     *
     * @param request 请求参数
     * @param path    请求路径
     * @return {@link String} 完整的 URL
     */
    private <O, T extends ResultResponse> String splicingGetRequest(BaseRequest<O, T> request, String path) {
        StringBuilder urlBuilder = new StringBuilder(gatewayHost);
        if (urlBuilder.toString().endsWith("/") && path.startsWith("/")) {
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        urlBuilder.append(path);
        if (!request.getRequestParams().isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, Object> entry : request.getRequestParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }
        log.info("GET请求路径：{}", urlBuilder);
        return urlBuilder.toString();
    }

    /**
     * 生成请求头
     *
     * @param body        请求体
     * @param caiApiClient CaiApiClient 客户端
     * @return {@link Map}<{@link String}, {@link String}> 请求头 Map
     */
    private Map<String, String> getHeaders(String body, CaiApiClient caiApiClient) {
        Map<String, String> hashMap = new HashMap<>(4);
        hashMap.put("accessKey", caiApiClient.getAccessKey());
        String encodedBody = SecureUtil.md5(body);
        hashMap.put("body", encodedBody);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.getSign(encodedBody, caiApiClient.getSecretKey()));
        return hashMap;
    }

    @Override
    public <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException {
        try {
            return res(request);
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    @Override
    public <O, T extends ResultResponse> T request(CaiApiClient caiApiClient, BaseRequest<O, T> request) throws ApiException {
        checkConfig(caiApiClient);
        return request(request);
    }
}
