package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.execption.ClaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClasesExceptionController {

    @ExceptionHandler(ClaseNotFoundException.class)
    public ResponseEntity<?> claseNotFoundException(ClaseNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
