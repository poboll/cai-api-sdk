package com.caiths.caiapisdk.exception;

/**
 * ApiException 类，表示自定义的异常类型，用于处理与 API 相关的错误。
 * <p>
 * 该类提供了构造函数来设置错误码和错误信息，可以用于标识不同类型的错误，并便于异常的捕获和处理。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
public class ApiException extends Exception {

    private static final long serialVersionUID = 2942420535500634982L;
    private int code;

    /**
     * 构造函数，通过错误码和错误信息初始化 ApiException 对象。
     *
     * @param code 错误码，用于标识错误类型
     * @param message 错误信息，描述具体的错误原因
     */
    public ApiException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数，通过错误信息和原始异常原因初始化 ApiException 对象。
     *
     * @param message 错误信息，描述具体的错误原因
     * @param cause 原始异常，用于追踪错误的根本原因
     */
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 构造函数，通过 ErrorCode 对象初始化 ApiException 对象。
     * <p>
     * ErrorCode 提供了标准的错误码和信息，使用它可以确保错误信息的一致性。
     * </p>
     *
     * @param errorCode ErrorCode 对象，包含错误码和错误信息
     */
    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    /**
     * 构造函数，通过 ErrorCode 对象和自定义的错误信息初始化 ApiException 对象。
     *
     * @param errorCode ErrorCode 对象，包含错误码和错误信息
     * @param message 自定义的错误信息
     */
    public ApiException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    /**
     * 获取异常的错误码。
     *
     * @return 错误码，表示具体的错误类型
     */
    public int getCode() {
        return code;
    }
}
