package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.AerolineasController;
import ar.com.codoacodo.flysky.exception.AerolineaNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.service.AerolineasServiceImpl;
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
public class AerolineasControllerTest {

    @Mock
    private AerolineasServiceImpl aerolineasService;

    @InjectMocks
    private AerolineasController aerolineasController;

    @Test
    @DisplayName("Test AerolineasController Camino Feliz -> todos")
    void todos() {
        // Arrange
        List<DtoAerolinea> aerolineasSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(aerolineasSut, HttpStatus.OK);

        when(aerolineasService.todasLasAerolineas()).thenReturn(aerolineasSut);

        // Act
        ResponseEntity<?> actual = aerolineasController.todos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AerolineasController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoAerolinea aerolineaSut = new DtoAerolinea();
        ResponseEntity<?> expected = new ResponseEntity<>(aerolineaSut, HttpStatus.OK);

        when(aerolineasService.buscarPorId(idSut)).thenReturn(aerolineaSut);

        // Act
        ResponseEntity<?> actual = aerolineasController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AerolineasController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoAerolinea aerolineaSut = new DtoAerolinea(); // Replace with your real instance of Aerolinea
        ResponseEntity<?> expected = new ResponseEntity<>(aerolineaSut, HttpStatus.OK);

        when(aerolineasService.agregarNueva(aerolineaSut)).thenReturn(aerolineaSut);

        // Act
        ResponseEntity<?> actual = aerolineasController.registrar(aerolineaSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AerolineasController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoAerolinea aerolineaSut = new DtoAerolinea(); // Replace with your real instance of Aerolinea
        ResponseEntity<?> expected = new ResponseEntity<>(aerolineaSut, HttpStatus.OK);

        when(aerolineasService.eliminar(idSut)).thenReturn(aerolineaSut);

        // Act
        ResponseEntity<?> actual = aerolineasController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    @DisplayName("Test AerolineasController Camino No Feliz -> seleccionar (Aerolinea no encontrada)")
    void seleccionarAerolineaNoEncontrada() {
        // Arrange
        Integer idSut = 1;

        // Mock
        when(aerolineasService.buscarPorId(idSut)).thenThrow(new AerolineaNoEncontrada());

        // Act and Assert
        assertThrows(AerolineaNoEncontrada.class, () -> aerolineasController.seleccionar(idSut));
    }

    @Test
    @DisplayName("Test AerolineasController Camino No Feliz -> eliminar (Aerolinea no encontrada)")
    void eliminarAerolineaNoEncontrada() {
        // Arrange
        Integer idSut = 1;

        // Mock
        when(aerolineasService.eliminar(idSut)).thenThrow(new AerolineaNoEncontrada());

        // Act and Assert
        assertThrows(AerolineaNoEncontrada.class, () -> aerolineasController.eliminar(idSut));
    }

}
