package com.spring.rubrica.interceptors;

import com.spring.rubrica.dto.ErroreDTO;
import com.spring.rubrica.exceptions.IdAlreadyRegisteredException;
import com.spring.rubrica.exceptions.NoIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestoreErrori {

    @ExceptionHandler
    public ResponseEntity<ErroreDTO> noIdHandler(NoIdException exc){
        ErroreDTO err = new ErroreDTO(exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErroreDTO> idGiaPresenteHandler(IdAlreadyRegisteredException exc){
        ErroreDTO err = new ErroreDTO(exc.getMessage());
        return new ResponseEntity<>(err, HttpStatus.CONFLICT);
    }


}
