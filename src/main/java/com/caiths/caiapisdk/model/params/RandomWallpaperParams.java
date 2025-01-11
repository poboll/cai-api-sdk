package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * RandomWallpaperParams 类，表示获取随机壁纸的请求参数。
 * <p>
 * 该类用于封装获取随机壁纸时所需的参数，可以在请求时传递相应的信息。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class RandomWallpaperParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    private String lx;
    private String method;
}
