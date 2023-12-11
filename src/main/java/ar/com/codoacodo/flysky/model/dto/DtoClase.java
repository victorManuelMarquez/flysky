package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DtoClase {

    @PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String nombre;

}
