package com.game.rockpaperscissor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class RPSExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Handles Custom Exception
     */
    @ExceptionHandler({ActionNotFoundException.class})
    public ResponseEntity<Object> handleBadRequest(final ActionNotFoundException e, final WebRequest request) {
        log.error("[ActionNotFoundException] : {}", e);
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleBadRequest(final RuntimeException e, final WebRequest request) {
        log.error("[RuntimeException] : {}", e);
        return handleExceptionInternal(e, new ErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @Data
    @AllArgsConstructor
    private class ErrorResponse {
        private String message;
        private HttpStatus httpStatus;
    }
}
