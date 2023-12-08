package ar.com.codoacodo.flysky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class AeropuertoDto {

    private Long id;
    private String nombre;
    private String ciudad;
}
