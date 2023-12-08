package ar.com.codoacodo.flysky.dto;

import lombok.Data;

@Data
public class AvionDto {

    private Long id;
    private String modelo;
    private int totalAsientos;
}
