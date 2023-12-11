package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DtoPago {

    @PositiveOrZero
    private Integer id;

    private DtoBoleto boleto;

    private DtoPasajero pasajero;

    @Positive
    private Float monto;

    @PastOrPresent
    private LocalDate fecha;

}
