package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.VuelosController;
import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.service.VuelosServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VuelosControllerTest {

    @Mock
    private VuelosServiceImpl vuelosService;

    @InjectMocks
    private VuelosController vuelosController;

    @Test
    @DisplayName("Test VuelosController Camino Feliz -> listarTodo")
    void listarTodo() {
        // Arrange
        List<DtoVuelo> vuelosSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(vuelosSut, HttpStatus.OK);

        when(vuelosService.todosLosVuelos()).thenReturn(vuelosSut);

        // Act
        ResponseEntity<?> actual = vuelosController.listarTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VuelosController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoVuelo vueloSut = new DtoVuelo();
        ResponseEntity<?> expected = new ResponseEntity<>(vueloSut, HttpStatus.OK);

        when(vuelosService.buscarPorId(idSut)).thenReturn(vueloSut);

        // Act
        ResponseEntity<?> actual = vuelosController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VuelosController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoVuelo vueloSut = new DtoVuelo(); // Replace with your actual DtoVuelo instance
        ResponseEntity<?> expected = new ResponseEntity<>(vueloSut, HttpStatus.OK);

        when(vuelosService.agregarVuelo(vueloSut)).thenReturn(vueloSut);

        // Act
        ResponseEntity<?> actual = vuelosController.registrar(vueloSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VuelosController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoVuelo vueloSut = new DtoVuelo(); // Replace with your actual DtoVuelo instance
        ResponseEntity<?> expected = new ResponseEntity<>(vueloSut, HttpStatus.OK);

        when(vuelosService.eliminar(idSut)).thenReturn(vueloSut);

        // Act
        ResponseEntity<?> actual = vuelosController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }


}
