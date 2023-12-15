package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.PasajerosExceptionController;
import ar.com.codoacodo.flysky.exception.ClaseNoEncontrada;
import ar.com.codoacodo.flysky.exception.PasajeroNoEncontrado;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestPasajerosExceptionController {
    @Autowired
    PasajerosExceptionController pasajerosExceptionController;
    @Test
    @DisplayName("Test Camino Feliz PasajeroException -> pasajeroNoEncontrado")
    void pasajeroNoEncontrado(){
        PasajeroNoEncontrado pasajeroNoEncontradoSut = new PasajeroNoEncontrado();
        ErrorDto body = new ErrorDto(404, pasajeroNoEncontradoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = pasajerosExceptionController.pasajeroNoEncontrado(pasajeroNoEncontradoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
