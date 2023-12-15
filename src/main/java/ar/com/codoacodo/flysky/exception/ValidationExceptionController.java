package ar.com.codoacodo.flysky.exception;

import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ValidationExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> errorValidacion(MethodArgumentNotValidException exception){
        List<ErrorDto> dtoErrors = new ArrayList<>();
        exception.getFieldErrors()
                .forEach(field -> dtoErrors.add(new ErrorDto(400, field.getDefaultMessage())));
        return new ResponseEntity<>(dtoErrors , HttpStatus.BAD_REQUEST);
    }
}
