package com.algodomain.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ServiceExceptionDto {
    private final String message;
    private final int status;
    private final String error;
    private final LocalDateTime timestamp;

    public ServiceExceptionDto(ServiceException ex) {
        this.message = ex.getMessage();
        this.status = ex.getStatus();
        this.error = ex.getError();
        this.timestamp = ex.getTimestamp();
    }
}
