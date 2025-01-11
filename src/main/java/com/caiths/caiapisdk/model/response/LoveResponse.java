package com.caiths.caiapisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LoveResponse 类，继承自 ResultResponse，用于表示随机情话的响应结果。
 * <p>
 * 该类包含响应数据的结构定义，适用于解析与随机情话相关的 API 返回内容。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoveResponse extends ResultResponse {
    private static final long serialVersionUID = -1038984103811824271L;
}
