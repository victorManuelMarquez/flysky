package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.VueloController;
import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.service.VueloServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

import static ar.com.codoacodo.flysky.util.VuelosTest.nuevoVuelo;
import static ar.com.codoacodo.flysky.util.VuelosTest.nuevosVuelos;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class VueloControllerTest {

    @Mock
    VueloServiceImp vueloServiceImp;

    @InjectMocks
    VueloController vueloController;

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
        RespuestaDto body = new RespuestaDto("Test VueloController -> guardarVuelo -> OK");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.guardarVuelo(any())).thenReturn(new RespuestaDto("Test VueloController -> guardarVuelo -> OK"));
        //Act
        ResponseEntity<?> actual = vueloController.guardarVuelo(vueloSut);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
    void listaVuelos(){
        //Arrange
        List<VueloDto> listaVuelosSut = nuevosVuelos();
        RespuestaDto body = new RespuestaDto("Test VueloController -> listaVuelos -> OK");
        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        when(vueloServiceImp.listaVuelos()).thenReturn(listaVuelosSut);
        //Act
        ResponseEntity<?> actual = vueloController.listaVuelos();
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
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
/*
    @Test
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
    void actualizarVueloPorId(){
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
    @DisplayName("Test VueloController Camino Feliz -> guardarVuelo")
    void borrarVueloPorId(){
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
    */

}
