package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.dto.DtoClase;

public class FactoryClaseTest {
    public static DtoClase nuevaClase(){
        return new DtoClase(11, "Prueba 11");
    }
    public static DtoClase eliminarClase(){
        return new DtoClase(10, "Premium First Class");
    }
}
