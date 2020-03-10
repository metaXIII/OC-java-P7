package com.librairie.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmailExistsExceptionThrowable extends Throwable {
    public EmailExistsExceptionThrowable(final String message) {
        super(message);
    }
}
