package ar.com.codoacodo.flysky.ControllerTest;

import ar.com.codoacodo.flysky.controller.VueloController;
import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.dto.AeropuertoDto;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        AerolineaDto aeroLineaSut =  new AerolineaDto(2L, "Flybondi");
        AeropuertoDto aeropuertoOrigenSut = new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires");
        AeropuertoDto aeropuertoDestinoSut = new AeropuertoDto(3L, "Aeropuerto Internacional de Los Ángeles", "Queens - New York - Estados Unidos");
        Date fechaSalida = new Date(2023,11,30,04,15,00);
        Date fechaLlegada = new Date(2023,11,30,22,15,00);

        VueloDto vueloSut = new VueloDto(1L , aeroLineaSut, fechaSalida, fechaLlegada ,  aeropuertoOrigenSut, aeropuertoDestinoSut);

        RespuestaDto body = new RespuestaDto("Test VueloController -> guardarVuelo -> OK");

        ResponseEntity<?> expected = new ResponseEntity<>(body, HttpStatus.OK);

        //Act
        ResponseEntity<?> actual = vueloController.guardarVuelo(vueloSut);

        //Assert
        assertEquals(expected, actual);
    }
}
