package com.caiths.caiapisdk.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CaiApiClient 类，封装与第三方 API 的交互方法，包括GET和POST请求的实现以及带签名的请求。
 * <p>
 * 该类提供了方法用于发送 GET 和 POST 请求，并能够附加签名信息以确保请求的安全性。
 * <p>
 *
 * @author poboll
 * @since 1.0 (2024年10月22日)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaiApiClient {
    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 密钥
     */
    private String secretKey;
}
