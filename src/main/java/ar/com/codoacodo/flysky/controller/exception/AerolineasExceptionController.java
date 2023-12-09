package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AerolineaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("SpellCheckingInspection")
public class AerolineasExceptionController {

    @ExceptionHandler(AerolineaNotFoundException.class)
    public ResponseEntity<?> aerolineaNotFound(AerolineaNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
