package com.caiths.caiapisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 随机壁纸响应模型
 * <p>
 * 表示从 API 返回的随机壁纸数据，包括图片的 URL。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RandomWallpaperResponse extends ResultResponse {
    private static final long serialVersionUID = -6467312483425078539L;

    /**
     * 壁纸图片的 URL
     */
    private String imgurl;
}
