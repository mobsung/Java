package org.spring.ecomm.interceptors;

import org.spring.ecomm.dto.ErrorItemDTO;
import org.spring.ecomm.exceptions.NoProductException;
import org.spring.ecomm.exceptions.NoStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ErrorHandlers {

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> noIdHandler(NoProductException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorItemDTO> idGiaPresenteHandler(NoStockException exc){
        ErrorItemDTO err = new ErrorItemDTO(
                LocalDate.now(),
                HttpStatus.CONFLICT,
                exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }


}
