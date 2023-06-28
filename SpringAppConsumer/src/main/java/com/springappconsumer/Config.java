package com.springappconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    public static final String BASE_URL = "http://localhost:8080/api/users";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
