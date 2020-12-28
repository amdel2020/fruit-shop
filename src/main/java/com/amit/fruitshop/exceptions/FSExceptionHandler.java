package com.amit.fruitshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FSExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FSErrorResponse> handleException(FSNotFoundException ex) {
        FSErrorResponse response = new FSErrorResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.ordinal());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<FSErrorResponse> handleException(FSUnauthorized ex) {
        FSErrorResponse response = new FSErrorResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.UNAUTHORIZED.ordinal());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<FSErrorResponse> handleException(Exception ex) {
        FSErrorResponse response = new FSErrorResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.ordinal());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
