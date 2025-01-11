package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * IpInfoParams 类，用于表示获取 IP 地址信息所需的请求参数。
 * <p>
 * 该类封装了一个 IP 地址，用于查询该 IP 地址的相关信息。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class IpInfoParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;

    /**
     * 要查询的 IP 地址。
     * <p>
     * 此字段用于指定要获取信息的目标 IP 地址。
     * </p>
     */
    private String ip;
}
