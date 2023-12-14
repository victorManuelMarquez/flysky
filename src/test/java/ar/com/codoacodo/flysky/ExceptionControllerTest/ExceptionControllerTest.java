package ar.com.codoacodo.flysky.ExceptionControllerTest;

import ar.com.codoacodo.flysky.controller.exception.*;
import ar.com.codoacodo.flysky.exception.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ExceptionControllerTest {

    @Autowired
    AerolineasExceptionController exceptionController;
    @Test
    @DisplayName("Test AerolineasExceptionController Camino Feliz -> La aerolínea no existe")
    void aerolineaNoEncontrada() {
        // Arrange
        AerolineaNoEncontrada exception = new AerolineaNoEncontrada();

        // Act
        ResponseEntity<?> actual = exceptionController.aerolineaNoEncontrada(exception);

        // Assert
        //assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

  /*  @Autowired
    AeropuertosExceptionController aeropuertosExceptionController;
    @Test
    @DisplayName("Test AeropuertosExceptionController Camino Feliz -> El Aeropuerto no existe")
    void aeropuertoNoEncontradoTest() {
        // Arrange
        AeropuertoNoEncontrado exception = new AeropuertoNoEncontrado("¡El aeropuerto no existe!");

        // Act
        ResponseEntity<?> actual = aeropuertosExceptionController.aeropuertoNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }
*/

    @Autowired
    AvionesExceptionController avionesExceptionController;
    @Test
    void avionNoEncontradoTest() {
        // Arrange
        AvionNoEncontrado exception = new AvionNoEncontrado("¡El avión no existe!");

        // Act
        ResponseEntity<?> actual = avionesExceptionController.avionNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }


    @Autowired
    BoletosExceptionController boletosExceptionController;
    @Test
    void boletoNoEncontradoTest() {
        // Arrange
        BoletoNoEncontrado exception = new BoletoNoEncontrado("¡El boleto no existe!");

        // Act
        ResponseEntity<?> actual = boletosExceptionController.boletoNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }

 /*   @Autowired
    AeronavesExceptionController aeronavesExceptionController;
    @Test
    void aeronaveNoEncontradaTest() {
        // Arrange
        AeronaveNoEncontrada exception = new AeronaveNoEncontrada("¡La aeronave no existe!");

        // Act
        ResponseEntity<?> actual = aeronavesExceptionController.aeronaveNoEncontrada(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
    }
*/




    @Autowired
    PagosExceptionController pagosExceptionController;
    @Test
    void pagoNoEncontradoTest() {
        // Arrange
        PagoNoEncontrado exception = new PagoNoEncontrado("¡El pago solicitado no existe!");

        // Act
        ResponseEntity<?> actual = pagosExceptionController.pagoNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
        //assertEquals("¡El pago solicitado no existe!", actual.getBody());
    }

    @Autowired
    VuelosExceptionController vuelosExceptionController;
    @Test
    void vueloNoEncontradoTest() {
        // Arrange
        VueloNoEncontrado exception = new VueloNoEncontrado("¡El vuelo solicitado no existe!");

        // Act
        ResponseEntity<?> actual = vuelosExceptionController.vueloNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
       //assertEquals("¡El vuelo solicitado no existe!", actual.getBody());
    }

    @Autowired
    ClasesExceptionController clasesExceptionController;

    @Test
    void claseNoEncontradaTest() {
        // Arrange
        ClaseNoEncontrada exception = new ClaseNoEncontrada("¡La clase especificada no existe!");

        // Act
        ResponseEntity<?> actual = clasesExceptionController.claseNoEncontrada(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
      //  assertEquals("¡La clase especificada no existe!", actual.getBody());
    }

    @Autowired
    PasajerosExceptionController pasajerOExceptionController;

    @Test
    void pasajeroNoEncontradoTest() {
        // Arrange
        PasajeroNoEncontrado exception = new PasajeroNoEncontrado("¡El pasajero solicitado no existe!");

        // Act
        ResponseEntity<?> actual = pasajerOExceptionController.pasajeroNoEncontrado(exception);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, actual.getStatusCode());
      //  assertEquals("¡El pasajero solicitado no existe!", actual.getBody());
    }
}

