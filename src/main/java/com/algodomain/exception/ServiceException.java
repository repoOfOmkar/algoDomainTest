package com.algodomain.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ServiceException extends RuntimeException {
    private final String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public String getError() {
        return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }
}
