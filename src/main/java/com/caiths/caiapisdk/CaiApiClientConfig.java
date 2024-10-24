package com.caiths.caiapisdk;

import com.caiths.caiapisdk.client.CaiApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "caiapi.client")
@ComponentScan
@Data
public class CaiApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public CaiApiClient caiApiClient(){
        return new CaiApiClient(accessKey, secretKey);
    }
}