package com.acem.demo.config;

import com.acem.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditingConfig {

    @Bean
    AuditorAware<User> auditorProvider() {
        return () -> {
            boolean isAuthentication = SecurityContextHolder
                                            .getContext()
                                            .getAuthentication()
                                            .isAuthenticated();

            if (isAuthentication) {
                User user = (User) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();
                return Optional.of(user);
            } else {
                return Optional.of(null);
            }
        };
    }
}
