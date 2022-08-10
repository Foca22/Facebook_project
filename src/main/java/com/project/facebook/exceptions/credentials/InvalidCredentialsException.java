package com.project.facebook.exceptions.credentials;

import com.project.facebook.exceptions.server.BaseException;

public class InvalidCredentialsException extends BaseException {
    public InvalidCredentialsException(String message, String errorCode) {
        super(message, errorCode);
    }

    public InvalidCredentialsException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
