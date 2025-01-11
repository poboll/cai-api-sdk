package com.caiths.caiapisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 名字响应模型
 * <p>
 * 表示从 API 返回的名字数据，包括名字字段。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NameResponse extends ResultResponse {
    private static final long serialVersionUID = -1038984103811824271L;

    /**
     * 返回的名字
     */
    private String name;
}
