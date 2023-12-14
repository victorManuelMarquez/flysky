package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.ClasesController;
import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.service.ClasesServiceImpl;
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
public class ClasesControllerTest {
    @Mock
    private ClasesServiceImpl clasesService;

    @InjectMocks
    private ClasesController clasesController;

    @Test
    @DisplayName("Test ClasesController Camino Feliz -> listarTodos")
    void listarTodos() {
        // Arrange
        List<DtoClase> clasesSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(clasesSut, HttpStatus.OK);

        when(clasesService.todasLasClases()).thenReturn(clasesSut);

        // Act
        ResponseEntity<?> actual = clasesController.listarTodos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ClasesController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoClase claseSut = new DtoClase();
        ResponseEntity<?> expected = new ResponseEntity<>(claseSut, HttpStatus.OK);

        when(clasesService.buscarPorId(idSut)).thenReturn(claseSut);

        // Act
        ResponseEntity<?> actual = clasesController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ClasesController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoClase claseSut = new DtoClase();
        ResponseEntity<?> expected = new ResponseEntity<>(claseSut, HttpStatus.OK);

        when(clasesService.agregarNueva(claseSut)).thenReturn(claseSut);

        // Act
        ResponseEntity<?> actual = clasesController.registrar(claseSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test ClasesController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoClase claseSut = new DtoClase();
        ResponseEntity<?> expected = new ResponseEntity<>(claseSut, HttpStatus.OK);

        when(clasesService.eliminar(idSut)).thenReturn(claseSut);

        // Act
        ResponseEntity<?> actual = clasesController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }
}
