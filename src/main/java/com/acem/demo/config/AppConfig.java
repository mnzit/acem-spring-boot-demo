package com.acem.demo.config;

import com.acem.demo.entity.Holiday;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Date, Holiday> holidays() {
        return new HashMap<>();
    }
}
