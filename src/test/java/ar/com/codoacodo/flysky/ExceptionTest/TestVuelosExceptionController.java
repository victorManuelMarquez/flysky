package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.controller.exception.VuelosExceptionController;
import ar.com.codoacodo.flysky.exception.VueloNoEncontrado;
import ar.com.codoacodo.flysky.exception.dto.ErrorDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestVuelosExceptionController {
    @Autowired
    VuelosExceptionController vuelosExceptionController;
    @Test
    @DisplayName("Test Camino Feliz VuelosException -> vueloNoEncontrado")
    void vueloNoEncontrado(){
        VueloNoEncontrado vueloNoEncontradoSut = new VueloNoEncontrado();
        ErrorDto body = new ErrorDto(404, vueloNoEncontradoSut.getMessage());
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        //ACT
        ResponseEntity<?> actual = vuelosExceptionController.vueloNoEncontrado(vueloNoEncontradoSut);
        //ASSERT
        assertEquals(expected , actual);
    }
}
