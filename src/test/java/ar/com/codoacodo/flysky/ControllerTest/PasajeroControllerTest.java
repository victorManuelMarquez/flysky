package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.PasajerosController;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
import ar.com.codoacodo.flysky.service.PasajerosServiceImpl;
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
public class PasajeroControllerTest {
    @Mock
    private PasajerosServiceImpl pasajerosService;

    @InjectMocks
    private PasajerosController pasajerosController;

    @Test
    @DisplayName("Test PasajerosController Camino Feliz -> listarTodo")
    void listarTodo() {
        // Arrange
        List<DtoPasajero> pasajerosSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(pasajerosSut, HttpStatus.OK);

        when(pasajerosService.todosLosPasajeros()).thenReturn(pasajerosSut);

        // Act
        ResponseEntity<?> actual = pasajerosController.listarTodo();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PasajerosController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoPasajero pasajeroSut = new DtoPasajero();
        ResponseEntity<?> expected = new ResponseEntity<>(pasajeroSut, HttpStatus.OK);

        when(pasajerosService.buscarPorId(idSut)).thenReturn(pasajeroSut);

        // Act
        ResponseEntity<?> actual = pasajerosController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PasajerosController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoPasajero pasajeroSut = new DtoPasajero();
        ResponseEntity<?> expected = new ResponseEntity<>(pasajeroSut, HttpStatus.OK);

        when(pasajerosService.agregarNuevo(pasajeroSut)).thenReturn(pasajeroSut);

        // Act
        ResponseEntity<?> actual = pasajerosController.registrar(pasajeroSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PasajerosController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoPasajero pasajeroSut = new DtoPasajero();
        ResponseEntity<?> expected = new ResponseEntity<>(pasajeroSut, HttpStatus.OK);

        when(pasajerosService.eliminar(idSut)).thenReturn(pasajeroSut);

        // Act
        ResponseEntity<?> actual = pasajerosController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }
}
