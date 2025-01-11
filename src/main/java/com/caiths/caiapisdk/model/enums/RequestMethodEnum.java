package com.caiths.caiapisdk.model.enums;

/**
 * RequestMethodEnum 枚举类，表示HTTP请求方法类型。
 * <p>
 * 该枚举类定义了常用的HTTP请求方法，包括GET和POST请求，用于API请求中的方法选择。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年11月21日)
 */
public enum RequestMethodEnum {
    /**
     * GET请求，表示获取数据。
     */
    GET("GET", "GET"),

    /**
     * POST请求，表示提交数据。
     */
    POST("POST", "POST");

    /**
     * 请求方法的文本描述。
     */
    private final String text;

    /**
     * 请求方法的具体值，通常为HTTP方法的名称。
     */
    private final String value;

    /**
     * 构造函数，初始化请求方法的文本描述和对应的值。
     *
     * @param text  请求方法的文本描述
     * @param value 请求方法的具体值
     */
    RequestMethodEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取请求方法的文本描述。
     *
     * @return 请求方法的文本描述
     */
    public String getText() {
        return text;
    }

    /**
     * 获取请求方法的具体值。
     *
     * @return 请求方法的具体值
     */
    public String getValue() {
        return value;
    }
}
