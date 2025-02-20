package br.com.ohgestor.msadmin.api.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AsaasConfig {

    @Value("${asaas.token}")
    private String accessToken;

    @Value("${asaas.url}")
    private String baseUrl;
}
