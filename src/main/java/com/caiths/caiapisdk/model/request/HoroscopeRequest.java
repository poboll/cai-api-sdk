package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.params.HoroscopeParams;
import com.caiths.caiapisdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * HoroscopeRequest 类，继承自 BaseRequest，表示星座请求。
 * <p>
 * 该类定义了获取星座相关信息的请求方法和路径，并实现了父类的抽象方法以适应具体的请求需求。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class HoroscopeRequest extends BaseRequest<HoroscopeParams, ResultResponse> {

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return "/horoscope";
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
