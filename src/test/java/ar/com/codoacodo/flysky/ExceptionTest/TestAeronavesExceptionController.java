package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.AeronavesExceptionController;
import ar.com.codoacodo.flysky.exception.AeronaveNoEncontrada;
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
public class TestAeronavesExceptionController {
    @Autowired
    AeronavesExceptionController aeronavesExceptionController;
    @Test
    @DisplayName("Test Camino Feliz AeronavesException -> aeronaveNoEncontrada")
    void aeronaveNoEncontrada(){
        //ARRANGE
        AeronaveNoEncontrada aeronaveNoEncontradaSut = new AeronaveNoEncontrada();
        ErrorDto body = new ErrorDto(404, aeronaveNoEncontradaSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = aeronavesExceptionController.aeronaveNoEncontrada(aeronaveNoEncontradaSut);
        //ASSERT
        assertEquals(expected , actual);
    }

}
