package com.caiths.caiapisdk.model.request;

import com.caiths.caiapisdk.model.enums.RequestMethodEnum;
import com.caiths.caiapisdk.model.params.RandomWallpaperParams;
import com.caiths.caiapisdk.model.response.RandomWallpaperResponse;
import lombok.experimental.Accessors;

/**
 * RandomWallpaperRequest 类，继承自 BaseRequest，用于处理随机壁纸相关的 API 请求。
 * <p>
 * 该类定义了请求的具体路径、方法和响应类型，适用于获取随机壁纸的功能。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Accessors(chain = true)
public class RandomWallpaperRequest extends BaseRequest<RandomWallpaperParams, RandomWallpaperResponse> {

    /**
     * 获取请求路径。
     *
     * @return {@link String} 请求路径
     */
    @Override
    public String getPath() {
        return "/randomWallpaper";
    }

    /**
     * 获取响应类，用于解析返回结果。
     *
     * @return {@link Class} 响应类
     */
    @Override
    public Class<RandomWallpaperResponse> getResponseClass() {
        return RandomWallpaperResponse.class;
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
