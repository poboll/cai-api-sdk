package com.caiths.caiapisdk.model.request;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.response.ResultResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * BaseRequest 类，表示基本的 API 请求。
 * <p>
 * 该类提供了通用的请求参数设置和获取方法，支持将请求参数从对象转换为 Map 格式。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
public abstract class BaseRequest<O, T extends ResultResponse> {
    private Map<String, Object> requestParams = new HashMap<>();

    /**
     * 获取请求方法（如GET、POST等）。
     *
     * @return {@link RequestMethodEnum} 请求方法
     */
    public abstract String getMethod();

    /**
     * 获取请求的路径。
     *
     * @return {@link String} 请求路径
     */
    public abstract String getPath();

    /**
     * 获取响应类，用于解析返回的结果。
     *
     * @return {@link Class} 响应类
     */
    public abstract Class<T> getResponseClass();

    /**
     * 获取请求参数。
     *
     * @return {@link Map} 请求参数
     */
    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    /**
     * 设置请求参数，将对象转化为Map形式。
     *
     * @param params 请求参数对象
     */
    public void setRequestParams(O params) {
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>() {
        }.getType());
    }
}
