package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;

public class FactoryAerolineasTest {
    public static DtoAerolinea nuevaAerolinea(){

        return new DtoAerolinea(55, "Aerolineas Nueva 55");
    }
}
