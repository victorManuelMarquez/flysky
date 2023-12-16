package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.*;
import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;

import java.time.LocalDate;
import java.util.Date;

public class FactoryPagosTest {
    public static DtoPago nuevoPago(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(2, "Aeropuerto Internacional Jorge Chávez", "Lima");
        Aerolinea aeroLineaSut =  new Aerolinea(6, "Avianca Ecuador");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(3, "Aeropuerto Internacional Guarulhos", "Sao Paulo");
        Date fechaSalida = new Date(2023,10,01);
        Date fechaLlegada = new Date(2023,10,02);

        DtoVuelo dtoVuelo = new DtoVuelo(4 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);

        DtoAeronave dtoAeronave = new DtoAeronave(11,
                new Avion(2, "Airbus A320"),
                new Clase(6, "Clase Ejecutiva "),
                1111);

        DtoBoleto dtoBoleto = new DtoBoleto(8, dtoVuelo, dtoAeronave, 1152F, LocalDate.now());

        DtoPasajero dtoPasajero = new DtoPasajero(11, "35658456", "Juan Pablo Montoya", "Avda Sanchez 2222",
                new Date(2023,11,30),
                "mail@gmail.com", "91-35658569");

        return new DtoPago(11, dtoBoleto, dtoPasajero, 1152F, LocalDate.now());
    }
    public static DtoPago eliminarPago(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(8, "Aeropuerto Internacional Jorge Chávez", "Lima");
        Aerolinea aeroLineaSut =  new Aerolinea(8, "Avianca Ecuador");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(3, "Aeropuerto Internacional Guarulhos", "Sao Paulo");
        Date fechaSalida = new Date(2023,10,01);
        Date fechaLlegada = new Date(2023,10,02);

        DtoVuelo dtoVuelo = new DtoVuelo(4 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);

        DtoAeronave dtoAeronave = new DtoAeronave(8,
                new Avion(8, "Airbus A350"),
                new Clase(8, "Clase Económica"),
                1111);

        DtoBoleto dtoBoleto = new DtoBoleto(8, dtoVuelo, dtoAeronave, 1152F, LocalDate.now());

        DtoPasajero dtoPasajero = new DtoPasajero(8, "891234567", "Laura Herrera", "Plaza 56",
                new Date(2023,04,30),
                "laura@example.com", "555-7890");

        return new DtoPago(8, dtoBoleto, dtoPasajero, 700F, LocalDate.now());
    }

}
