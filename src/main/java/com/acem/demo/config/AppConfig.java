package com.acem.demo.config;

import com.acem.demo.entity.Holiday;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<Date, Holiday> holidays() {
        return new HashMap<>();
    }

    @Bean
    public SecretKeySpec secretKey(){
        SecretKeySpec secretKey = new SecretKeySpec("123456789123456789123456789asdfg".getBytes(), "HmacSHA256");
        return secretKey;
    }
}
