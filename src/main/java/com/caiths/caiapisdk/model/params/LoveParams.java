package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * LoveParams 类，用于表示获取随机情话的请求参数。
 * <p>
 * 该类用于传递获取随机情话所需的参数，目前未定义具体字段，可根据需求进行扩展。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class LoveParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
}
