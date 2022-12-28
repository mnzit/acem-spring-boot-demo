package com.acem.demo.exception;

public class JwtExpiredException extends RuntimeException {

    public JwtExpiredException() {
        super("Jwt has expired");
    }
}
