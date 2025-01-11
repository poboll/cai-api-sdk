package com.caiths.caiapisdk.exception;

/**
 * ErrorCode 枚举，定义了常见的错误码及其对应的错误信息。
 * <p>
 * 该枚举包含了应用中可能出现的各种错误类型，使用错误码来标识不同的错误情况，并提供相应的错误信息。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
public enum ErrorCode {

    /**
     * 成功，表示请求成功。
     */
    SUCCESS(0, "ok"),

    /**
     * 请求参数错误，表示请求中的参数无效或不完整。
     */
    PARAMS_ERROR(40000, "请求参数错误"),

    /**
     * 未登录，表示用户未进行身份验证。
     */
    NOT_LOGIN_ERROR(40100, "未登录"),

    /**
     * 无权限，表示用户没有执行当前操作的权限。
     */
    NO_AUTH_ERROR(40101, "无权限"),

    /**
     * 请求数据不存在，表示请求的资源未找到。
     */
    NOT_FOUND_ERROR(40400, "请求数据不存在"),

    /**
     * 禁止访问，表示访问被禁止。
     */
    FORBIDDEN_ERROR(40300, "禁止访问"),

    /**
     * 系统错误，表示系统内部发生了异常。
     */
    SYSTEM_ERROR(50000, "系统内部异常"),

    /**
     * 操作错误，表示操作失败，通常是由用户操作或业务逻辑引起的错误。
     */
    OPERATION_ERROR(50001, "操作失败");

    /**
     * 状态码，表示错误类型。
     */
    private final int code;

    /**
     * 错误信息，提供具体的错误描述。
     */
    private final String message;

    /**
     * 构造函数，用于初始化错误码和错误信息。
     *
     * @param code 错误码
     * @param message 错误信息
     */
    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误码。
     *
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取错误信息。
     *
     * @return 错误信息
     */
    public String getMessage() {
        return message;
    }
}
