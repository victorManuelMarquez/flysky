package ar.com.codoacodo.flysky.ControllerTest;


import ar.com.codoacodo.flysky.controller.BoletosController;
import ar.com.codoacodo.flysky.model.dto.DtoBoleto;
import ar.com.codoacodo.flysky.service.BoletosServiceImpl;
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
public class BoletosControllerTest {

    @Mock
    private BoletosServiceImpl boletosService;

    @InjectMocks
    private BoletosController boletosController;

    @Test
    @DisplayName("Test BoletosController Camino Feliz -> listarTodos")
    void listarTodos() {
        // Arrange
        List<DtoBoleto> boletosSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(boletosSut, HttpStatus.OK);

        when(boletosService.todosLosBoletos()).thenReturn(boletosSut);

        // Act
        ResponseEntity<?> actual = boletosController.listarTodos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test BoletosController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoBoleto boletoSut = new DtoBoleto();
        ResponseEntity<?> expected = new ResponseEntity<>(boletoSut, HttpStatus.OK);

        when(boletosService.buscarPorId(idSut)).thenReturn(boletoSut);

        // Act
        ResponseEntity<?> actual = boletosController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test BoletosController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoBoleto boletoSut = new DtoBoleto();
        ResponseEntity<?> expected = new ResponseEntity<>(boletoSut, HttpStatus.OK);

        when(boletosService.agregarBoleto(boletoSut)).thenReturn(boletoSut);

        // Act
        ResponseEntity<?> actual = boletosController.registrar(boletoSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test BoletosController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoBoleto boletoSut = new DtoBoleto();
        ResponseEntity<?> expected = new ResponseEntity<>(boletoSut, HttpStatus.OK);

        when(boletosService.eliminar(idSut)).thenReturn(boletoSut);

        // Act
        ResponseEntity<?> actual = boletosController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }
}
