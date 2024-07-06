package com.gabortodor.petproject.controller;

import com.gabortodor.petproject.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Global exception handler for handling exceptions thrown within controllers.
 */
@Slf4j
@RestControllerAdvice
public final class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles {@link ResourceNotFoundException} and returns a BAD_REQUEST response.
     *
     * @param exception the exception to handle
     * @param request   the current request
     * @return the error message response
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Object handleBadRequestException(final ResourceNotFoundException exception, final WebRequest request) {
        return exception.generateErrorMessage();
    }

    /**
     * Handles {@link NoHandlerFoundException} and returns an INTERNAL_SERVER_ERROR response.
     *
     * @param exception the exception to handle
     * @param headers   the headers of the response
     * @param status    the HTTP status of the response
     * @param request   the current request
     * @return the error message response
     */
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles {@link MethodArgumentNotValidException} and returns a BAD_REQUEST response.
     *
     * @param exception the exception to handle
     * @param headers   the headers of the response
     * @param status    the HTTP status of the response
     * @param request   the current request
     * @return the error message response
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        final List<String> fieldErrors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getField).collect(Collectors.toList());
        return new ResponseEntity<>(String.join(",", fieldErrors), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles generic {@link Exception} and returns an INTERNAL_SERVER_ERROR response.
     *
     * @param exception the exception to handle
     * @param request   the current request
     * @return the error message response
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    Object defaultHandler(final Exception exception, final WebRequest request) {
        this.logger.error(exception.getMessage(), exception);
        return exception.getMessage();
    }

}


