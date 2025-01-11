package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * CurrencyRequest 类，继承自 BaseRequest，表示货币请求。
 * <p>
 * 该类定义了获取货币相关信息的请求方法和路径，并实现了父类的抽象方法以适应具体的请求需求。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class CurrencyRequest extends BaseRequest<Object, ResultResponse> {
    private String method;
    private String path;

    /**
     * 获取请求方法。
     *
     * @return {@link String} 请求方法
     */
    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
}
