package com.caiths.caiapisdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 毒鸡汤响应模型
 * <p>
 * 表示从 API 返回的毒鸡汤数据，包括文本内容。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PoisonousChickenSoupResponse extends ResultResponse {
    private static final long serialVersionUID = -6467312483425078539L;

    /**
     * 毒鸡汤的文本内容
     */
    private String text;
}
