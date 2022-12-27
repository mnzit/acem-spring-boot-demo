package com.acem.demo.exception;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException() {
        super("Jwt is not valid");
    }
}
