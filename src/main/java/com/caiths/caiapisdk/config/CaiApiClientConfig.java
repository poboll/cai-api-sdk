package com.caiths.caiapisdk;

import com.caiths.caiapisdk.client.CaiApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，用于设置并初始化 {@link CaiApiClient}。
 * 该类从配置文件中读取API客户端的配置，包括API密钥和秘密密钥，并提供一个Bean，
 * 以便Spring容器可以管理 {@link CaiApiClient} 实例。
 * <p>
 * 使用 {@code @Configuration} 标注该类为配置类，
 * 使用 {@code @ConfigurationProperties} 读取配置文件中的 "caiapi.client" 前缀的配置信息，
 * 使用 {@code @ComponentScan} 允许Spring自动扫描和注册当前包及其子包中的组件。
 * 使用 {@code @Data} 自动生成 Getter、Setter、toString 等常用方法。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年10月24日)
 */
@Configuration
@ConfigurationProperties(prefix = "caiapi.client")
@ComponentScan
@Data
public class CaiApiClientConfig {

    /**
     * API 访问密钥，从配置文件中获取。
     */
    private String accessKey;

    /**
     * API 秘密密钥，从配置文件中获取。
     */
    private String secretKey;

    /**
     * 创建并返回 {@link CaiApiClient} 实例，供 Spring 容器管理。
     * 使用从配置文件加载的 {@code accessKey} 和 {@code secretKey} 构造 {@link CaiApiClient} 实例。
     *
     * @return 已配置的 {@link CaiApiClient} 实例
     */
    @Bean
    public CaiApiClient caiApiClient() {
        return new CaiApiClient(accessKey, secretKey);
    }
}