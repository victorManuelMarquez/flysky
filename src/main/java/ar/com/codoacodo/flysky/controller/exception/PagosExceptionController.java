package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.PagoNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PagosExceptionController {

    @ExceptionHandler(PagoNoEncontrado.class)
    public ResponseEntity<?> pagoNoEncontrado(PagoNoEncontrado exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
