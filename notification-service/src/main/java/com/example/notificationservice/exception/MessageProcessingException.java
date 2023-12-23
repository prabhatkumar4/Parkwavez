package com.example.notificationservice.exception;

public class MessageProcessingException extends RuntimeException {
    public MessageProcessingException(String message, Exception cause) {
        super(message, cause);
    }
}
