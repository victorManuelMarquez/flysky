package ar.com.codoacodo.flysky.ExceptionTest;

import ar.com.codoacodo.flysky.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionsTest {

    @Test
    public void testAerolineaNoEncontrada() {
        AerolineaNoEncontrada excepcion = new AerolineaNoEncontrada();
        assertEquals("¡La aerolínea especificada no existe!", excepcion.getMessage());
    }

    @Test
    public void testAeronaveNoEncontrada() {
        AeronaveNoEncontrada excepcion = new AeronaveNoEncontrada();
        assertEquals("¡La aeronave solicitada no existe!", excepcion.getMessage());
    }

    @Test
    public void testVueloNoEncontrado() {
        VueloNoEncontrado excepcion = new VueloNoEncontrado();
        assertEquals("¡El vuelo solicitado no existe!", excepcion.getMessage());
    }

    @Test
    public void testPasajeroNoEncontrado() {
        PasajeroNoEncontrado excepcion = new PasajeroNoEncontrado();
        assertEquals("¡El pasajero solicitado no existe!", excepcion.getMessage());
    }

    @Test
    public void testAeropuertoNoEncontrado() {
        AeropuertoNoEncontrado excepcion = new AeropuertoNoEncontrado();
        assertEquals("¡El aeropuerto solicitado no existe!", excepcion.getMessage());
    }

    @Test
    public void testAvionNoEncontrado() {
        AvionNoEncontrado excepcion = new AvionNoEncontrado();
        assertEquals("¡El avión solicitado no existe!", excepcion.getMessage());
    }

    @Test
    public void testPagoNoEncontrado() {
        PagoNoEncontrado excepcion = new PagoNoEncontrado();
        assertEquals("¡El pago solicitado no existe!", excepcion.getMessage());
    }
}

