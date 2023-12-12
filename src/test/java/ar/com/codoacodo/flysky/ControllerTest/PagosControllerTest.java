package ar.com.codoacodo.flysky.ControllerTest;


import ar.com.codoacodo.flysky.controller.PagosController;
import ar.com.codoacodo.flysky.model.dto.DtoPago;
import ar.com.codoacodo.flysky.service.PagosServiceImpl;
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
public class PagosControllerTest {

    @Mock
    private PagosServiceImpl pagosService;

    @InjectMocks
    private PagosController pagosController;

    @Test
    @DisplayName("Test PagosController Camino Feliz -> todos")
    void todos() {
        // Arrange
        List<DtoPago> pagosSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(pagosSut, HttpStatus.OK);

        when(pagosService.todosLosPagos()).thenReturn(pagosSut);

        // Act
        ResponseEntity<?> actual = pagosController.todos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PagosController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoPago pagoSut = new DtoPago();
        ResponseEntity<?> expected = new ResponseEntity<>(pagoSut, HttpStatus.OK);

        when(pagosService.buscarPorId(idSut)).thenReturn(pagoSut);

        // Act
        ResponseEntity<?> actual = pagosController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PagosController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoPago pagoSut = new DtoPago(); // Replace with your real instance of Pago
        ResponseEntity<?> expected = new ResponseEntity<>(pagoSut, HttpStatus.OK);

        when(pagosService.agregarNuevo(pagoSut)).thenReturn(pagoSut);

        // Act
        ResponseEntity<?> actual = pagosController.registrar(pagoSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test PagosController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoPago pagoSut = new DtoPago(); // Replace with your real instance of Pago
        ResponseEntity<?> expected = new ResponseEntity<>(pagoSut, HttpStatus.OK);

        when(pagosService.eliminar(idSut)).thenReturn(pagoSut);

        // Act
        ResponseEntity<?> actual = pagosController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }
}

