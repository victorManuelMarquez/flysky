package ar.com.codoacodo.flysky.dto;

import ar.com.codoacodo.flysky.entity.Clasea;
import lombok.Data;

@Data
public class AsientoDto {

    private Long id;
    private Clasea clasea;  // Cambia el nombre de la propiedad
    private double precio;
    private int cantidad;

}
