package com.caiths.caiapisdk.model;

import lombok.Data;

/**
 * 表示 API 调用过程中使用的用户信息的实体类。
 * <p>
 * 该类包含用户基本信息，如用户名。通过 Lombok 的 {@code @Data} 注解自动为类的字段生成 Getter、Setter、
 * toString、equals 和 hashCode 方法，从而简化了类的实现。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年10月22日)
 */
@Data
public class User {

    /**
     * 用户名，用于在API调用中唯一标识用户。
     * <p>
     * 此字段值是用户的主要标识符，用于用户验证和用户信息检索等操作。
     * </p>
     */
    private String username;
}