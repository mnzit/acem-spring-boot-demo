package com.acem.demo.exception;

import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailedException extends AuthenticationException {

    public AuthenticationFailedException() {
        super("Unauthorized");
    }
}
