package com.caiths.caiapisdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * 提供接口签名生成功能的工具类。
 * <p>
 * 主要用于生成接口调用中的签名信息，确保请求的完整性和安全性。该类使用 Hutool 的加密库来生成 SHA-256 哈希签名。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年10月22日)
 */
public class SignUtil {

    /**
     * 生成基于 SHA-256 算法的签名。
     * <p>
     * 该方法使用请求体内容和密钥生成签名。首先将请求体内容和密钥拼接为一个字符串，然后使用 SHA-256 算法计算哈希值，最后返回该哈希值的十六进制字符串。
     * </p>
     *
     * @param body 请求体内容，通常是请求参数的序列化字符串
     * @param secretKey 用于签名的密钥，保证只有授权的客户端能生成和验证签名
     * @return 生成的签名字符串，为 SHA-256 哈希值的十六进制表示
     */
    public static String genSign(String body, String secretKey) {
        Digester sha256 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "." + secretKey; // 拼接内容和密钥
        return sha256.digestHex(content); // 生成并返回签名
    }
}