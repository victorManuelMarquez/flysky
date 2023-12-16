package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;

public class FactoryAerolineasTest {
    public static DtoAerolinea nuevaAerolinea(){
        return new DtoAerolinea(15, "Aerolinea Nueva 15");
    }
    public static DtoAerolinea eliminarAerolinea(){
        return new DtoAerolinea(10, "Copa Airlines");
    }
}