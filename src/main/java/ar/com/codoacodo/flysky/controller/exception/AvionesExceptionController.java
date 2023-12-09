package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AvionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@SuppressWarnings("SpellCheckingInspection")
public class AvionesExceptionController {

    @ExceptionHandler(AvionNotFoundException.class)
    public ResponseEntity<?> avionNotFound(AvionNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
