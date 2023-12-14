package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.AerolineasExceptionController;
import ar.com.codoacodo.flysky.exception.AerolineaNoEncontrada;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestAerolineasExceptionController {
    @Autowired
    AerolineasExceptionController aerolineasExceptionController;
    @Test
    @DisplayName("Test Camino Feliz AerolineasException -> aerolineaNoEncontrada")
    void aerolineaNoEncontrada(){
        //ARRANGE
        AerolineaNoEncontrada aerolineaNoEncontradaSut = new AerolineaNoEncontrada();
        ErrorDto body = new ErrorDto(404, aerolineaNoEncontradaSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = aerolineasExceptionController.aerolineaNoEncontrada(aerolineaNoEncontradaSut);
        //ASSERT
        assertEquals(expected , actual);
    }




}
