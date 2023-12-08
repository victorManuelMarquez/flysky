package ar.com.codoacodo.flysky.dto;

import lombok.Data;

@Data
public class AsientoDto {

    private Long id;
    private Long id_clase; // Mantén consistencia en el nombre del campo
    private Float precio;
    private Integer cantidad;

    public AsientoDto(Long id, Long id_clase, Float precio, Integer cantidad) {
        this.id = id;
        this.id_clase = id_clase; // Ajusta el nombre aquí para que coincida
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public AsientoDto() {
    }
}