package org.spring.ecomm.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class ErrorItemDTO {

    private LocalDate timestamp;
    private HttpStatus status;
    private final String error = "Conflitto";
    private String message;

    public ErrorItemDTO(LocalDate timestamp, HttpStatus status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
