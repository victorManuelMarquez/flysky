package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;

public class FactoryAeropuertosTest {
    public static DtoAeropuerto nuevoAeropuerto(){
        return new DtoAeropuerto(11, "Aeropuerto Prueba", "Ciudad Prueba");
    }
    public static DtoAeropuerto eliminarAeropuerto(){
        return new DtoAeropuerto(10, "Aeropuerto Internacional Tocumen", "Panamá");
    }
}