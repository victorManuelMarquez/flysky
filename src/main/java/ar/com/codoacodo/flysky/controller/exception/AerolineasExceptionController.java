package ar.com.codoacodo.flysky.controller.exception;

import ar.com.codoacodo.flysky.exception.AerolineaNoEncontrada;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AerolineasExceptionController {

    @ExceptionHandler(AerolineaNoEncontrada.class)
    public ResponseEntity<?> aerolineaNoEncontrada(AerolineaNoEncontrada exception) {
        ErrorDto error = new ErrorDto(404, exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
