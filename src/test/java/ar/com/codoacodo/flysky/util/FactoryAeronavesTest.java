package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;

public class FactoryAeronavesTest {
    public static DtoAeronave nuevaAeronave(){
        return new DtoAeronave(11,
                new Avion(2, "Airbus A320"),
                new Clase(6, "Clase Ejecutiva"),
                1111);
    }

    public static DtoAeronave eliminarAeronave(){
        return new DtoAeronave(9,
                new Avion(9, "Embraer E195"),
                new Clase(9, "Premium Business"),
                120);
    }
}