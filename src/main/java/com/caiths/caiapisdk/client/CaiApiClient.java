package com.caiths.caiapisdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.caiths.caiapisdk.utils.SignUtil;
import com.caiths.caiapisdk.model.User;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * CaiApiClient 类，封装与第三方 API 的交互方法，包括GET和POST请求的实现以及带签名的请求。
 * <p>
 * 该类提供了方法用于发送 GET 和 POST 请求，并能够附加签名信息以确保请求的安全性。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年10月22日)
 */
public class CaiApiClient {
    private String accessKey;
    private String secretKey;

    // 定义API网关的地址，实际使用时应替换为生产环境的地址
    public static final String GATEWAY_HOST = "http://localhost:8123";

    /**
     * 构造函数，通过访问密钥和秘密密钥初始化CaiApiClient对象。
     *
     * @param accessKey 用于身份验证的访问密钥
     * @param secretKey 用于生成签名的秘密密钥
     */
    public CaiApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * 通过GET方法调用API，根据用户名查询信息。
     *
     * @param name 要查询的用户名
     * @return 返回API响应的结果字符串
     */
    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    /**
     * 通过POST方法调用API，根据用户名发送信息。
     *
     * @param name 要查询的用户名
     * @return 返回API响应的结果字符串
     */
    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    /**
     * 通过POST方法调用API，并在请求头部附加签名信息。请求体为JSON格式的User对象。
     *
     * @param user 要发送的User对象，包含用户名信息
     * @return 返回API响应的结果字符串
     * @throws UnsupportedEncodingException 当编码过程中发生不支持的编码异常时抛出
     */
    public String getUserNameByPost(User user) throws UnsupportedEncodingException {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user/")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    /**
     * 生成包含签名的请求头部，以确保请求的安全性。
     * 包括访问密钥、签名、加密的请求体、随机数、时间戳等信息。
     *
     * @param body 请求体内容，通常为JSON字符串
     * @return 返回包含签名和其他安全信息的头部Map
     * @throws UnsupportedEncodingException 当编码过程中发生不支持的编码异常时抛出
     */
    private Map<String, String> getHeaderMap(String body) throws UnsupportedEncodingException {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        hashMap.put("sign", SignUtil.genSign(body, secretKey));
        hashMap.put("body", URLEncoder.encode(body, StandardCharsets.UTF_8.name()));
        hashMap.put("nonce", RandomUtil.randomNumbers(5));
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
        // System.out.println("Generated Headers: " + hashMap);
        return hashMap;
    }
}