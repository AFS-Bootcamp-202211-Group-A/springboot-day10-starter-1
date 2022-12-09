package com.rest.springbootemployee.exception;

public class IdInvalidException extends RuntimeException {
    public IdInvalidException() {
        super("ID is invalid");
    }
}
