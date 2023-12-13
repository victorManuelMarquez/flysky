package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.dto.DtoClase;

public class FactoryClaseTest {
    public static int id = 11;
    public static DtoClase nuevaClase(){
        id++;
        return new DtoClase(id, "Prueba "+id);
    }
    public static DtoClase eliminarClase(){
        --id;
        return new DtoClase(id, "Prueba "+id);
    }
}
