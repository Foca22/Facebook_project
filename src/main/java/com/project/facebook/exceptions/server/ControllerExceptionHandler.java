package com.project.facebook.exceptions.server;

import com.project.facebook.dto.error.ErrorDto;
import com.project.facebook.exceptions.credentials.InvalidCredentialsException;
import com.project.facebook.exceptions.post.PostNotFoundException;
import com.project.facebook.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handleUserNotFoundException(Exception exception) {
        return handleBaseException(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({PostNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto handlePostNotFoundException(Exception exception) {
        return handleBaseException(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({InvalidCredentialsException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto handleInvalidCredentialException(Exception exception){
        return handleBaseException(exception, HttpStatus.FORBIDDEN);
    }

    private ErrorDto handleBaseException(Exception exception, HttpStatus httpStatus) {
        BaseException baseException = (BaseException) exception;
        return new ErrorDto(baseException.getErrorCode(), baseException.getMessage(), httpStatus.value());
    }
}
