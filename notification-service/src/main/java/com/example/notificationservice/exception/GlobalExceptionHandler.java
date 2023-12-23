package com.example.notificationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.notificationservice.exception.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MessageProcessingException.class)
    public ResponseEntity<Object> handleMessageProcessingException(MessageProcessingException ex) {
        // Log the exception
        log.error("Exception occurred during message processing: {}", ex.getMessage());
        
        ErrorResponse errorResponse = new ErrorResponse("Error processing message", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
