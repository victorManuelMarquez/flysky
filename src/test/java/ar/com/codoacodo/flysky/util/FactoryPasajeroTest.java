package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.dto.PasajeroDto;

public class FactoryPasajeroTest {
    public static PasajeroDto unPasajero(){
        return new PasajeroDto(1L, "Juan Pablo", "Sanchez", "35658569");
    }

}
