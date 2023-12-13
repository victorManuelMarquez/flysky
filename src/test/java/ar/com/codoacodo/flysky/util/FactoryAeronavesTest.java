package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;

public class FactoryAeronavesTest {
    public static int id = 57;
    public static DtoAeronave nuevaAeronave(){
        id++;
        return new DtoAeronave(id,
                new Avion(2, "Airbus A320"+id),
                new Clase(6, "Clase Ejecutiva "+id),
                300);
    }

    public static DtoAeronave eliminarAeronave(){
        --id;
        return new DtoAeronave(id,
                new Avion(2, "Airbus A320"+id),
                new Clase(6, "Clase Ejecutiva "+id),
                300);
    }
}

