package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class DtoAsiento {

    @PositiveOrZero
    private Integer id;

    @NotNull
    private DtoClase clase;

    @Positive
    private Integer cantidad;

    @Positive
    private Float precio;

}
