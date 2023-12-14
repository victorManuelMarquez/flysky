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

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VueloControllerTest {
/*
    @Mock
    VuelosServiceImpl vueloServiceImp;

    @InjectMocks
    VuelosController vueloController;

    @Test
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
    void guardarVuelo(){
        //Arrange
        VueloDto vueloSut = nuevoVuelo();
        RespuestaDto body = new RespuestaDto("Test VueloController -> guardarVuelo -> OK");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.guardarVuelo(any())).thenReturn(new RespuestaDto("Test VueloController -> guardarVuelo -> OK"));
        //Act
        ResponseEntity<?> actual = vueloController.guardarVuelo(vueloSut);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> comprarBoleto")
    void comprarBoleto(){
        //Arrange
        VueloDto vueloSut = nuevoVuelo();
        RespuestaDto body = new RespuestaDto("Test VueloController -> comprarBoleto -> OK");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.guardarVuelo(any())).thenReturn(new RespuestaDto("Test VueloController -> comprarBoleto -> OK"));
        //Act
        ResponseEntity<?> actual = vueloController.guardarVuelo(vueloSut);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> listaVuelos")
    void listaVuelos(){
        //Arrange
        List<DtoVuelo> listaVuelosSut = nuevosVuelos();
        ResponseEntity<?> expected = new ResponseEntity<>(listaVuelosSut, HttpStatus.OK);

        when(vueloServiceImp.listaVuelos()).thenReturn(listaVuelosSut);
        //Act
        ResponseEntity<?> actual = vueloController.listaVuelos();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> buscarVueloPorId")
    void buscarVueloPorId(){
        //Arrange
        Long idSut = 1L;
        VueloDto body = nuevoVuelo();
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.buscarVueloPorId(idSut)).thenReturn(body);
        //Act
        ResponseEntity<?> actual = vueloController.buscarVueloPorId(idSut);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> actualizarVueloPorId")
    void actualizarVueloPorId(){
        //Arrange
        Long idSut = 1L;
        VueloDto vueloSut = nuevoVuelo();
        ResponseEntity<?> expected = new ResponseEntity<>(new RespuestaDto("Vuelo actualizado correctamente"), HttpStatus.OK);

        when(vueloServiceImp.actualizarVueloPorId(idSut, vueloSut)).thenReturn(new RespuestaDto("Vuelo actualizado correctamente"));
        //Act
        ResponseEntity<?> actual = vueloController.actualizarVueloPorId(idSut, vueloSut);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
    void borrarVueloPorId(){
        //Arrange
        Long idSut = 1L;
        RespuestaDto body = new RespuestaDto("Vuelo borrado");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.borrarVueloPorId(any())).thenReturn(new RespuestaDto("Vuelo borrado"));
        //Act
        ResponseEntity<?> actual = vueloController.borrarVueloPorId(idSut);
        //Assert
        assertEquals(expected, actual);
    }

*/
}
