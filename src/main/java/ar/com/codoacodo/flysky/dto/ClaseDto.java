package ar.com.codoacodo.flysky.dto;

import lombok.Data;

@Data
public class ClaseDto {

    private Long id;
    private String nombre;

    public ClaseDto(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ClaseDto() {
    }
}
