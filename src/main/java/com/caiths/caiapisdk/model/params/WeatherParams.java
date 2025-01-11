package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * WeatherParams 类，表示获取天气的请求参数。
 * <p>
 * 该类用于封装获取天气时所需的参数，包括IP地址、城市名称和天气类型。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class WeatherParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    private String ip;
    private String city;
    private String type;
}
