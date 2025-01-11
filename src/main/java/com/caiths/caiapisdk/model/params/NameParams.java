package com.caiths.caiapisdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * NameParams 类，用于表示查询姓名相关信息的请求参数。
 * <p>
 * 该类用于传递姓名作为请求参数，通常用于根据姓名获取用户信息等相关操作。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
@Accessors(chain = true)
public class NameParams implements Serializable {
    private static final long serialVersionUID = 3815188540434269370L;
    /**
     * 姓名，作为查询或请求的参数
     */
    private String name;
}
