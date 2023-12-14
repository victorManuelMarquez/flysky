package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.AeropuertosController;
import ar.com.codoacodo.flysky.exception.AeropuertoNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.service.AeropuertosServiceImpl;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AeropuertoControllerTest {

    @Mock
    private AeropuertosServiceImpl aeropuertosService;

    @InjectMocks
    private AeropuertosController aeropuertoController;

    @Test
    @DisplayName("Test AeropuertoController Camino Feliz -> listarTodo")
    void listarTodo() {
        // Arrange
        List<DtoAeropuerto> aeropuertosSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(aeropuertosSut, HttpStatus.OK);

        when(aeropuertosService.todosLosAeropuertos()).thenReturn(aeropuertosSut);

        // Act
        ResponseEntity<?> actual = aeropuertoController.todos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeropuertoController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoAeropuerto aeropuertoSut = new DtoAeropuerto();
        ResponseEntity<?> expected = new ResponseEntity<>(aeropuertoSut, HttpStatus.OK);

        when(aeropuertosService.buscarPorId(idSut)).thenReturn(aeropuertoSut);

        // Act
        ResponseEntity<?> actual = aeropuertoController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeropuertoController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoAeropuerto aeropuertoSut = new DtoAeropuerto();
        ResponseEntity<?> expected = new ResponseEntity<>(aeropuertoSut, HttpStatus.OK);

        when(aeropuertosService.agregarNuevo(aeropuertoSut)).thenReturn(aeropuertoSut);

        // Act
        ResponseEntity<?> actual = aeropuertoController.registrar(aeropuertoSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeropuertoController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoAeropuerto aeropuertoSut = new DtoAeropuerto();
        ResponseEntity<?> expected = new ResponseEntity<>(aeropuertoSut, HttpStatus.OK);

        when(aeropuertosService.eliminar(idSut)).thenReturn(aeropuertoSut);

        // Act
        ResponseEntity<?> actual = aeropuertoController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeropuertoController Camino No Feliz -> seleccionar (Aeronpuerto no encontrado)")
    void seleccionarAeropuertoNoEncontrado() {
        // Arrange
        Integer idSut = 1;

        // Mock

        when(aeropuertosService.buscarPorId(idSut)).thenThrow(new AeropuertoNoEncontrado());

        // Act and Assert
        assertThrows(AeropuertoNoEncontrado.class, () -> aeropuertoController.seleccionar(idSut));
    }

    @Test
    @DisplayName("Test AeropuertoController Camino No Feliz -> eliminar (Aeropuerto no encontrada)")
    void eliminarAeropuertoNoEncontrado() {
        // Arrange
        Integer idSut = 1;

        // Mock
        when(aeropuertosService.eliminar(idSut)).thenThrow(new AeropuertoNoEncontrado());

        // Act and Assert
        assertThrows(AeropuertoNoEncontrado.class, () -> aeropuertoController.eliminar(idSut));
    }
}

