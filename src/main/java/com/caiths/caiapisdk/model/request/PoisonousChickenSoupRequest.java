package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.params.PoisonousChickenSoupParams;
import com.caiths.caiapisdk.model.response.PoisonousChickenSoupResponse;
import lombok.experimental.Accessors;

/**
 * PoisonousChickenSoupRequest 类，继承自 BaseRequest，用于处理毒鸡汤相关的 API 请求。
 * <p>
 * 该类定义了请求的具体路径、方法和响应类型，适用于获取毒鸡汤内容的功能。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class PoisonousChickenSoupRequest extends BaseRequest<PoisonousChickenSoupParams, PoisonousChickenSoupResponse> {

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return "/poisonousChickenSoup";
    }

    /**
     * 获取响应类，用于解析返回结果。
     *
     * @return {@link Class} 响应类
     */
    @Override
    public Class<PoisonousChickenSoupResponse> getResponseClass() {
        return PoisonousChickenSoupResponse.class;
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
