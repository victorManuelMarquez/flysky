package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.*;
import jakarta.validation.constraints.*;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoInforme {
    @PositiveOrZero
    private Integer idInforme;

    private DtoPasajero dtoPasajero;

    @NotBlank
    private String asientop;

    @NotBlank
    private String destinop;

    @NotBlank
    private String pagop;
}
