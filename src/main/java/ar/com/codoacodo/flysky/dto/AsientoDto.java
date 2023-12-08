package ar.com.codoacodo.flysky.dto;

import lombok.*;

@Data
public class AsientoDto {

    private Long id;
    private ClaseDto clase;
    private Float precio;
    private Integer cantidad;


}