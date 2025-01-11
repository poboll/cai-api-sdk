package com.caiths.caiapisdk.exception;

import lombok.Data;

/**
 * ErrorResponse 类，表示错误响应信息的封装。
 * <p>
 * 该类用于统一返回API的错误信息，包括错误消息和错误码。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
@Data
public class ErrorResponse {
    /**
     * 错误信息，描述错误的具体内容。
     */
    private String message;

    /**
     * 错误码，标识错误的类型或原因。
     */
    private int code;
}
