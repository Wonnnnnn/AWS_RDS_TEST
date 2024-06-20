package org.example.aws_sample.exception;

import org.example.aws_sample.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.View;

@RestControllerAdvice
public class ExceptionAdvice {
    private final View error;

    public ExceptionAdvice(View error) {
        this.error = error;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> illegalArgumentExceptionAdvice(IllegalArgumentException e) {
        return new Response("fail",e.getMessage().toString(), null);
    }

    @ExceptionHandler(NoIdExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> NoIdExistsExceptionAdvice(NoIdExistsException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }

    @ExceptionHandler(DuplicateNameException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> DuplicateNameExceptionAdvice(DuplicateNameException e) {
        return new Response("fail", e.getMessage().toString(), null);
    }

}
