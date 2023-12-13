package ar.com.codoacodo.flysky.util;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class FactoryAeropuertosTest {
    public static int id = 57;
    public static DtoAeropuerto nuevoAeropuerto(){
        id++;
        return new DtoAeropuerto(id, "Aeropuerto Prueba "+id, "Ciudad Pruebaz "+id);
    }
    public static DtoAeropuerto eliminarAeropuerto(){
        --id;
        return new DtoAeropuerto(id, "Aeropuerto Prueba "+id, "Ciudad Pruebaz "+id);
    }
}
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String ciudad;
*/