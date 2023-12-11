package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoBoleto {

    @PositiveOrZero
    private Integer id;

    private DtoVuelo vuelo;

    private DtoAeronave aeronave;

    @Positive
    private Float precio;

    private LocalDate reserva;

}
