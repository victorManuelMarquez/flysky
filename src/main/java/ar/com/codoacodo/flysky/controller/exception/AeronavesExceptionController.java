package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AeronaveNoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AeronavesExceptionController {

    @ExceptionHandler(AeronaveNoEncontrada.class)
    private ResponseEntity<?> aeronaveNoEncontrada(AeronaveNoEncontrada exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
