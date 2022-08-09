package com.project.facebook.exceptions.post;

import com.project.facebook.exceptions.server.BaseException;

public class PostNotFoundException extends BaseException {
    public PostNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public PostNotFoundException(String message, Throwable cause, String errorCode) {
        super(message, cause, errorCode);
    }
}
