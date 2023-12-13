package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.BoletosExceptionController;
import ar.com.codoacodo.flysky.exception.BoletoNoEncontrado;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestBoletosExceptionController {
    @Autowired
    BoletosExceptionController boletosExceptionController;
    @Test
    @DisplayName("Test Camino Feliz BoletosException -> boletoNoEncontrado")
    void boletoNoEncontrado(){
        BoletoNoEncontrado boletoNoEncontradoSut = new BoletoNoEncontrado();
        ErrorDto body = new ErrorDto(404, boletoNoEncontradoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = boletosExceptionController.boletoNoEncontrado(boletoNoEncontradoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
