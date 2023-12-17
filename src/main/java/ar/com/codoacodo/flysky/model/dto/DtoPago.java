package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.MetodoPago;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoPago {

    @PositiveOrZero
    private Integer id;

    private DtoBoleto boleto;

    private DtoPasajero pasajero;

    @Positive
    private Float monto;

    @PastOrPresent
    private LocalDate fecha;

    private DtoMetodoPago metodoPago;

    private DtoInforme informe;
}
