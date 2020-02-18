package com.librairie.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UsernameExistsException extends Throwable {
    public UsernameExistsException(final String message) {
        super(message);
    }
}
