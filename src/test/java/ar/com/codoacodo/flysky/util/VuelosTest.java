package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.dto.AeropuertoDto;
import ar.com.codoacodo.flysky.dto.VueloDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VuelosTest {
    public static VueloDto nuevoVuelo(){
        AerolineaDto aeroLineaSut =  new AerolineaDto(2L, "Flybondi");
        AeropuertoDto aeropuertoOrigenSut = new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires");
        AeropuertoDto aeropuertoDestinoSut = new AeropuertoDto(3L, "Aeropuerto Internacional de Los Ángeles", "Queens - New York - Estados Unidos");
        Date fechaSalida = new Date(2023,11,30,04,15,00);
        Date fechaLlegada = new Date(2023,11,30,22,15,00);

        return new VueloDto(1L , aeroLineaSut, fechaSalida, fechaLlegada ,  aeropuertoOrigenSut, aeropuertoDestinoSut);
    }

   public static List<VueloDto> nuevosVuelos(){
        return new ArrayList<>(List.of(
                new VueloDto(1L ,  new AerolineaDto(2L, "Flybondi"),
                        new Date(2023,11,30,04,15,00),
                        new Date(2023,11,30,22,15,00),
                        new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires"),
                        new AeropuertoDto(3L, "Aeropuerto Internacional de Tokio", "Tokio - Japón")),
                new VueloDto(2L , new AerolineaDto(1L, "Aerolíneas Argentinas"),
                        new Date(2023,11,29,16,24,00),
                        new Date(2023,11,30,22,15,00),
                        new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires"),
                        new AeropuertoDto(1L, "Aeropuerto Internacional de Los Ángeles", "Los Ángeles - California - Estados Unidos"))
        ));

    }
}
