package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.AerolineasExceptionController;
import ar.com.codoacodo.flysky.controller.exception.PagosExceptionController;
import ar.com.codoacodo.flysky.exception.ClaseNoEncontrada;
import ar.com.codoacodo.flysky.exception.PagoNoEncontrado;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestPagosExceptionController {
    @Autowired
    PagosExceptionController pagosExceptionController;
    @Test
    @DisplayName("Test Camino Feliz PagosException -> pagoNoEncontrado")
    void boletoNoEncontrado(){
        PagoNoEncontrado pagoNoEncontradoSut = new PagoNoEncontrado();
        ErrorDto body = new ErrorDto(404, pagoNoEncontradoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = pagosExceptionController.pagoNoEncontrado(pagoNoEncontradoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
