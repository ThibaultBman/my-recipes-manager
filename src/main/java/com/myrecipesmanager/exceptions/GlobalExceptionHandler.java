package com.myrecipesmanager.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Entity not found
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlerEntityNotFoundException(EntityNotFoundException e) {
        return e.getMessage();
    }

    // Wrong type argument
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return "The parameter " + e.getName() + " value is incorrect";
    }

    // Null value in model with @NotNull annotation
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handlerIllegalArgumentException(ConstraintViolationException e) {
        return "Invalid model";
    }

    // Wrong HTTP method
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public String handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return "Method not allowed";
    }
}
