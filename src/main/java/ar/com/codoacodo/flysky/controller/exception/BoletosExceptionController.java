package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.BoletoNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BoletosExceptionController {

    @ExceptionHandler(BoletoNoEncontrado.class)
    public ResponseEntity<?> boletoNoEncontrado(BoletoNoEncontrado exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.OK);
    }

}