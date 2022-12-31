package com.acem.demo.service;

    public interface EmailService {
        void sendSimpleMessage(String to,
                               String subject,
                               String text);
}
