package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.params.NameParams;
import com.caiths.caiapisdk.model.response.NameResponse;
import lombok.experimental.Accessors;

/**
 * NameRequest 类，继承自 BaseRequest，用于处理姓名相关的 API 请求。
 * <p>
 * 该类定义了请求的具体路径、方法和响应类型，适用于获取姓名相关数据的功能。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class NameRequest extends BaseRequest<NameParams, NameResponse> {

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return "/name";
    }

    /**
     * 获取响应类，用于解析返回结果。
     *
     * @return {@link Class} 响应类
     */
    @Override
    public Class<NameResponse> getResponseClass() {
        return NameResponse.class;
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
