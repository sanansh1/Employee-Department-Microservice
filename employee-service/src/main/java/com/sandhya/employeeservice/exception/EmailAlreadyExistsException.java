package com.sandhya.employeeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {
    private final String message;

    public EmailAlreadyExistsException(String message) {
        super(String.format("%s", message));
        this.message = message;
    }
}
