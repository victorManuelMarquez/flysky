package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactoryVuelosTest {
    public static DtoVuelo nuevoVuelo(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(4, "Aeropuerto Internacional Ministro Pistarini", "Buenos Aires");
        Aerolinea aeroLineaSut =  new Aerolinea(1, "LATAM Airlines");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(3, "Aeropuerto Internacional Guarulhos", "Sao Paulo");
        Date fechaSalida = new Date(2023,12,30);
        Date fechaLlegada = new Date(2023,12,30);

        return new DtoVuelo(11 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);
    }
    public static DtoVuelo eliminarVuelo(){
        Aeropuerto aeropuertoOrigenSut = new Aeropuerto(2, "Aeropuerto Internacional Jorge Chávez", "Lima");
        Aerolinea aeroLineaSut =  new Aerolinea(6, "Avianca Ecuador");
        Aeropuerto aeropuertoDestinoSut = new Aeropuerto(3, "Aeropuerto Internacional Guarulhos", "Sao Paulo");
        Date fechaSalida = new Date(2023,10,01);
        Date fechaLlegada = new Date(2023,10,02);

        return new DtoVuelo(6 , aeropuertoOrigenSut, aeroLineaSut, aeropuertoDestinoSut, fechaSalida, fechaLlegada);
    }
}
    /*
   public static List<DtoVuelo> nuevosVuelos(){
        return new ArrayList<>(List.of(
                new DtoVuelo(1L ,  new AerolineaDto(2L, "Flybondi"),
                        new Date(2023,11,30,04,15,00),
                        new Date(2023,11,30,22,15,00),
                        new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires"),
                        new AeropuertoDto(3L, "Aeropuerto Internacional de Tokio", "Tokio - Japón")),
                new DtoVuelo(2L , new AerolineaDto(1L, "Aerolíneas Argentinas"),
                        new Date(2023,11,29,16,24,00),
                        new Date(2023,11,30,22,15,00),
                        new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires"),
                        new AeropuertoDto(1L, "Aeropuerto Internacional de Los Ángeles", "Los Ángeles - California - Estados Unidos"))
        ));**/




