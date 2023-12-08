package ar.com.codoacodo.flysky.dto;

import ar.com.codoacodo.flysky.entity.Clase;
import lombok.Data;

@Data
public class AsientoDto {

    private Long id;

    private Clase clase;

    private double precio;

    private int cantidad;
}
