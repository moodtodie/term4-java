package com.github.moodtodie.lab1.controllers;

import com.github.moodtodie.lab1.entities.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;

@RestControllerAdvice
public class ControllerAdvisor {
    public static final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    //  500 | unchecked
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> globalExceptionHandler(Exception error, WebRequest request) {
        Error message = new Error(
                new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                error.getMessage()
        );

        logger.error(String.format("Status code: \"500\"; Request: \"%s\"", request.getDescription(true)));

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //  400 | Not valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> customValidation(MethodArgumentNotValidException error) {
        Error message = new Error(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                error.getMessage()
        );
        logger.warn(String.format("Status code: \"400\", Exception: Not valid, Message: \"%s\".", error.getMessage()));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    //  400 | Type mismatch
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Error> customValidation(MethodArgumentTypeMismatchException error) {
        Error message = new Error(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                error.getMessage()
        );
        logger.warn(String.format("Status code: \"400\", Exception: Type mismatch, Message: \"%s\".", error.getMessage()));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    //  400 | Conversion not supported
    @ExceptionHandler(MethodArgumentConversionNotSupportedException.class)
    public ResponseEntity<Error> customValidation(MethodArgumentConversionNotSupportedException error) {
        Error message = new Error(
                new Date(),
                HttpStatus.BAD_REQUEST.value(),
                error.getMessage()
        );
        logger.warn(String.format("Status code: \"400\", Exception: Conversion not supported, Message: \"%s\".", error.getMessage()));

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
