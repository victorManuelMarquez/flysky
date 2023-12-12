package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.Aviones;
import ar.com.codoacodo.flysky.model.entity.Clases;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class DtoAeronave {

    @PositiveOrZero
    private Integer id;

    private Aviones avion;

    private Clases clase;

    @Positive
    private Integer asientos;

}
