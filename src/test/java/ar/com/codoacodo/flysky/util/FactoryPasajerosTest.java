package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.DtoClase;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;

import java.util.Date;

public class FactoryPasajerosTest {
    public static DtoPasajero nuevaPasajero(){
        return new DtoPasajero(11, "35658456", "Juan Pablo Montoya", "Avda Sanchez 2222",
                new Date(2023,11,30),
                "mail@gmail.com", "91-35658569");
    }
    public static DtoPasajero eliminarPasajero(){
        return new DtoPasajero(10, "445566778", "Sofía López", "Travesía 21",
                new Date(1983,02,28),
                "sofia@example.com", "555-8901");
    }

}
