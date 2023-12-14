package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.AvionesController;
import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.service.AvionesServicioImpl;
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
public class AvionesControllerTest {
    @Mock
    private AvionesServicioImpl avionesServicio;

    @InjectMocks
    private AvionesController avionesController;

    @Test
    @DisplayName("Test AvionesController Camino Feliz -> listarTodo")
    void listarTodo() {
        // Arrange
        List<DtoAvion> avionesSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(avionesSut, HttpStatus.OK);

        when(avionesServicio.todosLosAviones()).thenReturn(avionesSut);

        // Act
        ResponseEntity<?> actual = avionesController.listarTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AvionesController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoAvion avionSut = new DtoAvion();
        ResponseEntity<?> expected = new ResponseEntity<>(avionSut, HttpStatus.OK);

        when(avionesServicio.buscarPorId(idSut)).thenReturn(avionSut);

        // Act
        ResponseEntity<?> actual = avionesController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AvionesController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoAvion avionSut = new DtoAvion();
        ResponseEntity<?> expected = new ResponseEntity<>(avionSut, HttpStatus.OK);

        when(avionesServicio.agregarNuevo(avionSut)).thenReturn(avionSut);

        // Act
        ResponseEntity<?> actual = avionesController.registrar(avionSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AvionesController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoAvion avionSut = new DtoAvion();
        ResponseEntity<?> expected = new ResponseEntity<>(avionSut, HttpStatus.OK);

        when(avionesServicio.eliminar(idSut)).thenReturn(avionSut);

        // Act
        ResponseEntity<?> actual = avionesController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

}
