package ar.com.codoacodo.flysky.util;


import ar.com.codoacodo.flysky.model.dto.*;

import java.util.Calendar;
import java.util.Date;

public class FactoryBoletosTest {

    public static DtoBoleto nuevoPasajero(){
        return new DtoBoleto(); /*(55,
                new DtoVuelo(),
                new DtoAeronave(),
                125F,
                new Date(2023,11,30,04,15,00));
         */
    }
    public static int id = 57;
    /* public static DtoBoleto nuevoBoleto(){
        id++;
        return new DtoBoleto(id, "prueba "+id);
    }
    public static DtoBoleto eliminarBoleto(){
        --id;
        return new DtoBoleto(id, "Prueba "+id);
    }*/

}
/*
@PositiveOrZero
    private Integer id;

    private DtoVuelo vuelo;

    private DtoAeronave aeronave;

    @Positive
    private Float precio;

    private LocalDate reserva;
*
vuelo
AeropuertoDto aeropuertoOrigenSut = new AeropuertoDto(1L, "Aeropuerto Internacional Ezeiza", "Ezeiza - Pcia. de Buenos Aires");
AeropuertoDto aeropuertoDestinoSut = new AeropuertoDto(3L, "Aeropuerto Internacional de Los Ángeles", "Queens - New York - Estados Unidos");

PositiveOrZero
    private Integer id;
    private Aeropuerto origen;
    new Aeropuerto(55, ")
    private Aerolinea aerolinea;
    private Aeropuerto destino;
    private Date salida;
    private Date llegada;

aeropuerto
@PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nombre;

    @NotBlank
    @Size(max = 100)
    private String ciudad;

*/