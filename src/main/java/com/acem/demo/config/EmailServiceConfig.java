package com.acem.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailServiceConfig {

    @Value("${spring.mail.host}")
    private String mailServerHost;

    @Value("${spring.mail.port}")
    private Integer mailServerPort;

    @Value("${spring.mail.username}")
    private String mailServerUsername;

    @Value("${spring.mail.password}")
    private String mailServerPassword;

    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String mailServerAuth;

    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String mailServerStartTls;

//    @Value("${spring.mail.properties.mail.smtp.ssl.trust}")
//    private String mailSmtpSslTrust;

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        Properties props = mailSender.getJavaMailProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.auth", mailServerAuth);
//        props.setProperty("mail.smtp.ssl.trust", mailSmtpSslTrust);
        props.setProperty("mail.smtp.starttls.enable", mailServerStartTls);
        props.setProperty("mail.debug", "false");

        mailSender.setHost(mailServerHost);
        mailSender.setPort(mailServerPort);
        mailSender.setUsername(mailServerUsername);
        mailSender.setPassword(mailServerPassword);

        return mailSender;
    }
}
