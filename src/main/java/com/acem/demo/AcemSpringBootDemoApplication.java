package com.acem.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AcemSpringBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcemSpringBootDemoApplication.class, args);
    }


    @Bean
    @Profile("dev")
    public Map<String, String> devBean(){
        System.out.println("bean1 created");

        Map<String, String> map = new HashMap<>();
        map.put("data", "1");
        return map;
    }

    @Bean
    @Profile("prod")
    public Map<String, String> prodBean(){
        System.out.println("bean2 created");

        Map<String, String> map = new HashMap<>();
        map.put("data", "2");
        return map;
    }
}
