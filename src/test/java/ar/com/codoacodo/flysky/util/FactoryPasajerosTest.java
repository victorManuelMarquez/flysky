package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.DtoPasajero;

import java.util.Date;

public class FactoryPasajerosTest {
   public static int id = 11;
    public static DtoPasajero nuevaPasajero(){
        id++;
        return new DtoPasajero(id, "35658456", "Juan Pablo Montoya", "Avda Sanchez 2222",
                new Date(2023,11,30,04,15,00), "mail@gmail.com", "91-35658569");
    }
    public static DtoPasajero eliminarPasajero(){
        --id;
        return new DtoPasajero(id, "35658456", "Juan Pablo Montoya", "Avda Sanchez 2222",
                new Date(2023,11,30,04,15,00), "mail@gmail.com", "91-35658569");
    }

}
