package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.AeronavesController;
import ar.com.codoacodo.flysky.exception.AeronaveNoEncontrada;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.service.AeronavesServiceImpl;
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
public class AeronaveControllerTest {

    @Mock
    private AeronavesServiceImpl aeronaveService;

    @InjectMocks
    private AeronavesController aeronaveController;

    @Test
    @DisplayName("Test AeronaveController Camino Feliz -> listarTodo")
    void listarTodo() {
        // Arrange
        List<DtoAeronave> aeronavesSut = new ArrayList<>();
        ResponseEntity<?> expected = new ResponseEntity<>(aeronavesSut, HttpStatus.OK);

        when(aeronaveService.todasLasAeronaves()).thenReturn(aeronavesSut);

        // Act
        ResponseEntity<?> actual = aeronaveController.todos();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeronaveController Camino Feliz -> seleccionar")
    void seleccionar() {
        // Arrange
        Integer idSut = 1;
        DtoAeronave aeronaveSut = new DtoAeronave();
        ResponseEntity<?> expected = new ResponseEntity<>(aeronaveSut, HttpStatus.OK);

        when(aeronaveService.buscarPorId(idSut)).thenReturn(aeronaveSut);

        // Act
        ResponseEntity<?> actual = aeronaveController.seleccionar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeronaveController Camino Feliz -> registrar")
    void registrar() {
        // Arrange
        DtoAeronave aeronaveSut = new DtoAeronave();
        ResponseEntity<?> expected = new ResponseEntity<>(aeronaveSut, HttpStatus.OK);

        when(aeronaveService.agregarAeronave(aeronaveSut)).thenReturn(aeronaveSut);

        // Act
        ResponseEntity<?> actual = aeronaveController.registrar(aeronaveSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeronaveController Camino Feliz -> eliminar")
    void eliminar() {
        // Arrange
        Integer idSut = 1;
        DtoAeronave aeronaveSut = new DtoAeronave();
        ResponseEntity<?> expected = new ResponseEntity<>(aeronaveSut, HttpStatus.OK);

        when(aeronaveService.eliminar(idSut)).thenReturn(aeronaveSut);

        // Act
        ResponseEntity<?> actual = aeronaveController.eliminar(idSut);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test AeronaveController Camino No Feliz -> seleccionar (Aeronave no encontrada)")
    void seleccionarAeronaveNoEncontrada() {
        // Arrange
        Integer idSut = 1;

        // Mock
        when(aeronaveService.buscarPorId(idSut)).thenThrow(new AeronaveNoEncontrada());

        // Act and Assert
        assertThrows(AeronaveNoEncontrada.class, () -> aeronaveController.seleccionar(idSut));
    }

    @Test
    @DisplayName("Test AeronaveController Camino No Feliz -> eliminar (Aeronave no encontrada)")
    void eliminarAeronaveNoEncontrada() {
        // Arrange
        Integer idSut = 1;

        // Mock
        when(aeronaveService.eliminar(idSut)).thenThrow(new AeronaveNoEncontrada());

        // Act and Assert
        assertThrows(AeronaveNoEncontrada.class, () -> aeronaveController.eliminar(idSut));
    }


}
