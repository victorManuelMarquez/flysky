package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.VueloNoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class VuelosExceptionController {

    @ExceptionHandler(VueloNoEncontrado.class)
    public ResponseEntity<?> vueloNoEncontrado(VueloNoEncontrado exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
