package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.ClaseNoEncontrada;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ClasesExceptionController {

    @ExceptionHandler(ClaseNoEncontrada.class)
    public ResponseEntity<?> claseNoEncontrada(ClaseNoEncontrada exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

}
