package com.caiths.caiapisdk.config;

import com.caiths.caiapisdk.client.CaiApiClient;
import com.caiths.caiapisdk.service.ApiService;
import com.caiths.caiapisdk.service.impl.ApiServiceImpl;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
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
 * 使用 {@code @ConfigurationProperties} 读取配置文件中的 "cai.api.client" 前缀的配置信息，
 * 使用 {@code @ComponentScan} 允许Spring自动扫描和注册当前包及其子包中的组件。
 * 使用 {@code @Data} 自动生成 Getter、Setter、toString 等常用方法。
 * </p>
 *
 * @author poboll
 * @since 1.0 (2024年10月24日)
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "cai.api.client")
@ComponentScan
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
     * API 访问网关，从配置文件中获取。
     */
    private String host;

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

    /**
     * 创建并返回 {@link ApiService} 实例，供 Spring 容器管理。
     * 根据配置文件中的网关地址设置 {@link ApiService} 的网关地址。
     * 如果配置文件中没有提供网关地址，使用默认值。
     *
     * @return 已配置的 {@link ApiService} 实例
     */
    @Bean
    public ApiService apiService() {
        ApiServiceImpl apiService = new ApiServiceImpl();
        // 设置 API 客户端
        apiService.setCaiApiClient(new CaiApiClient(accessKey, secretKey));
        // 如果配置文件中提供了网关地址，则设置它；否则使用默认值
        if (StringUtils.isNotBlank(host)) {
            apiService.setGatewayHost(host);
        }
        return apiService;
    }
}
