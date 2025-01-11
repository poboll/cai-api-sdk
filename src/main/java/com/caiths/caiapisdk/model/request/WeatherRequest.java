package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.params.WeatherParams;
import com.caiths.caiapisdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * WeatherRequest 类，继承自 BaseRequest，用于处理获取天气相关的 API 请求。
 * <p>
 * 该类定义了请求的具体路径、方法和响应类型，适用于获取天气信息的功能。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class WeatherRequest extends BaseRequest<WeatherParams, ResultResponse> {

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return "/weather";
    }

    /**
     * 获取响应类，用于解析返回结果。
     *
     * @return {@link Class} 响应类
     */
    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }

    /**
     * 获取请求方法。
     *
     * @return {@link String} 请求方法
     */
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }
}
