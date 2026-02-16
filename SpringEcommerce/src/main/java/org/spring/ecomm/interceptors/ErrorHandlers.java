package org.spring.ecomm.interceptors;

import org.spring.ecomm.dto.ErrorItemDTO;
import org.spring.ecomm.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ErrorHandlers {

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> noIdHandler(ProductNotFoundException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> idGiaPresenteHandler(InsufficientStockException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.CONFLICT,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> invalidStateHandler(InvalidOrderStateException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> orderAlreadyPresentHandler(OrderAlreadyPresentException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> orderNotFoundHandler(OrderNotFoundException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


}
