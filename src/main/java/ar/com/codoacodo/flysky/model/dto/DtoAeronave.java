package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuppressWarnings("SpellCheckingInspection")
public class DtoAeronave {

    @PositiveOrZero
    private Integer id;

    private Avion avion;

    private Clase clase;

    @Positive
    private Integer asientos;

}
