package com.in48iliass.microservices.github.configuration;

import com.in48iliass.microservices.github.exception.Handler.GitHubRestTemplateErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateWithErrorHandlerConfig {
    @Bean
    RestTemplate restTemplateWithErrorHandler() {
        return new RestTemplateBuilder()
                .errorHandler(new GitHubRestTemplateErrorHandler())
                .build();
    }
}
