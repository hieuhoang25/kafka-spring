package com.hicode.notificationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@Configuration
public class AppConfig {
    @Bean
    JsonMessageConverter converter(){
        return new JsonMessageConverter();
    }
}
