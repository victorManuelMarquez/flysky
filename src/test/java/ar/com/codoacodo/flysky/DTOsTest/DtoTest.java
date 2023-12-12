package ar.com.codoacodo.flysky.DTOsTest;


import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DtoTest {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    @Test
    void testDtoAerolineaValidation() {
        DtoAerolinea dtoAerolinea = new DtoAerolinea(1, "Aerolinea1");

        Set<ConstraintViolation<DtoAerolinea>> violations = validator.validate(dtoAerolinea);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testDtoAeronaveValidation() {
        DtoAeronave dtoAeronave = new DtoAeronave(1, new Avion(), new Clase(), 150);

        Set<ConstraintViolation<DtoAeronave>> violations = validator.validate(dtoAeronave);
        assertTrue(violations.isEmpty());
    }
/*
    @Test
    void testDtoVueloValidation() {

        DtoVuelo dtoVuelo = new DtoVuelo(1, new Aeropuerto(), new Aerolinea(), new Aeropuerto(), new Date(), new Date());

        Set<ConstraintViolation<DtoVuelo>> violations = validator.validate(dtoVuelo);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testDtoPasajeroValidation() {
        DtoPasajero dtoPasajero = new DtoPasajero(1, "123456789", "Nombre Apellido", "Dirección", new Date(), "correo@example.com", "123456789");



        Set<ConstraintViolation<DtoPasajero>> violations = validator.validate(dtoPasajero);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testDtoPagoValidation() {
        DtoPago dtoPago = new DtoPago(1, new DtoBoleto(), new DtoPasajero(), 500.0f, LocalDate.now());

        Set<ConstraintViolation<DtoPago>> violations = validator.validate(dtoPago);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testDtoBoletoValidation() {
        DtoBoleto dtoBoleto = new DtoBoleto(1, new DtoVuelo(), new DtoAeronave(), 300.0f, LocalDate.now());

        Set<ConstraintViolation<DtoBoleto>> violations = validator.validate(dtoBoleto);
        assertTrue(violations.isEmpty());
    }*/
}
