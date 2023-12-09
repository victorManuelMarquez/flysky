package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AsientoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AsientosExceptionController {

    @ExceptionHandler(AsientoNotFoundException.class)
    public ResponseEntity<?> asientoNotFound(AsientoNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}