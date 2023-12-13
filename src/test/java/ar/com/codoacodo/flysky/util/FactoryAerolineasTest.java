package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;

public class FactoryAerolineasTest {
    public static int id = 80;
    public static DtoAerolinea nuevaAerolinea(){
        id++;
        return new DtoAerolinea(id, "Aerolineas Nueva "+id);
    }
    public static DtoAerolinea eliminarAerolinea(){
        --id;
        return new DtoAerolinea(id, "Aerolineas Nueva "+id);
    }
}
