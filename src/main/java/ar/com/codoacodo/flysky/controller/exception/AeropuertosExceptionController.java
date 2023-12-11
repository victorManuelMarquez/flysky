package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AeropuertoNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AeropuertosExceptionController {

    @ExceptionHandler(AeropuertoNoEncontrado.class)
    public ResponseEntity<?> aeropuertoNoEncontrado(AeropuertoNoEncontrado exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
