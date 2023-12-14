package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.ClasesExceptionController;
import ar.com.codoacodo.flysky.exception.ClaseNoEncontrada;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestClasesExceptionController {
    @Autowired
    ClasesExceptionController clasesExceptionController;
    @Test
    @DisplayName("Test Camino Feliz ClasesException -> claseNoEncontrada")
    void claseNoEncontrado(){
        ClaseNoEncontrada claseNoEncontradaoSut = new ClaseNoEncontrada();
        ErrorDto body = new ErrorDto(404, claseNoEncontradaoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = clasesExceptionController.claseNoEncontrada(claseNoEncontradaoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
