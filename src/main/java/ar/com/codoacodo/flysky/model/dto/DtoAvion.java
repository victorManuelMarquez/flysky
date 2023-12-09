package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@SuppressWarnings("SpellCheckingInspection")
public class DtoAvion {

    @PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String modelo;

    @Positive
    private Integer totalAsientos;

}
