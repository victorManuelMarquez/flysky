package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.*;
import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class FactoryBoletosTest {

    public static DtoBoleto nuevoBoleto(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(4, "Aeropuerto Internacional Ministro Pistarini", "Buenos Aires");
        Aerolinea aeroLineaSut =  new Aerolinea(1, "LATAM Airlines");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(3, "Aeropuerto Internacional Guarulhos", "Sao Paulo");
        Date fechaSalida = new Date(2023,12,30);
        Date fechaLlegada = new Date(2023,12,30);

        DtoVuelo dtoVuelo = new DtoVuelo(11 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);

        DtoAeronave dtoAeronave =  new DtoAeronave(11,
                new Avion(2, "Airbus A320"),
                new Clase(6, "Clase Ejecutiva"),
                1111);

        return new DtoBoleto(11, dtoVuelo, dtoAeronave, 125F, LocalDate.now());
    }

    public static DtoBoleto eliminarBoleto(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(9, "Aeropuerto Internacional Simón Bolívar", "Caracas");
        Aerolinea aeroLineaSut =  new Aerolinea(5, "TAME Ecuador");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(10, "Aeropuerto Internacional Tocumen", "Panamá");
        Date fechaSalida = new Date(2023,12,30);
        Date fechaLlegada = new Date(2023,12,30);

        DtoVuelo dtoVuelo = new DtoVuelo(11 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);

        DtoAeronave dtoAeronave =  new DtoAeronave(11,
                new Avion(2, "Airbus A320"),
                new Clase(6, "Clase Ejecutiva"),
                1111);

        return new DtoBoleto(5, dtoVuelo, dtoAeronave, 125F, LocalDate.now());

    }


}
