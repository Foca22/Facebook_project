package com.project.facebook.exceptions.messages;

import org.springframework.http.HttpStatus;

public enum ExceptionMessages {

    USER_NOT_FOUND("User not found!", HttpStatus.NOT_FOUND.toString()),
    POST_NOT_FOUND("Post not found!", HttpStatus.NOT_FOUND.toString()),
    INVALID_CREDENTIALS("Credentials not valid!", HttpStatus.FORBIDDEN.toString());


   private final String errorMessage;
   private final String httpStatusCode;

    ExceptionMessages(String errorMessage, String httpStatusCode) {
        this.errorMessage = errorMessage;
        this.httpStatusCode = httpStatusCode;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }
}
