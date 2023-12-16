package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.AeropuertosExceptionController;
import ar.com.codoacodo.flysky.exception.AeropuertoNoEncontrado;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public class TestAeropuertosExceptionController {
    @Autowired
    AeropuertosExceptionController aeropuertosExceptionController;

    @Test
    @DisplayName("Test Camino Feliz AeropuertosException -> aeropuertoNoEncontrado")
    void aeropuertoNoEncontrado(){
        //ARRANGE
        AeropuertoNoEncontrado aeropuertoNoEncontradoSut = new AeropuertoNoEncontrado();
        ErrorDto body = new ErrorDto(404, aeropuertoNoEncontradoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = aeropuertosExceptionController.aeropuertoNoEncontrado(aeropuertoNoEncontradoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
