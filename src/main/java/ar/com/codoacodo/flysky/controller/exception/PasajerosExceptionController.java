package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.PasajeroNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PasajerosExceptionController {

    @ExceptionHandler(PasajeroNoEncontrado.class)
    public ResponseEntity<?> pasajeroNoEncontrado(PasajeroNoEncontrado exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
