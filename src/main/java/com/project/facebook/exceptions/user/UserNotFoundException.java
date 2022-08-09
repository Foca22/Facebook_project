package com.project.facebook.exceptions.user;

import com.project.facebook.exceptions.server.BaseException;

public class UserNotFoundException extends BaseException {


    public UserNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public UserNotFoundException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
