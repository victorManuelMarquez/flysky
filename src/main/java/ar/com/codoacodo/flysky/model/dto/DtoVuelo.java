package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class DtoVuelo {

    @PositiveOrZero
    private Integer id;

    private Aeropuerto origen;

    private Aerolinea aerolinea;

    private Aeropuerto destino;

    private LocalDate salida;

    private LocalDate llegada;

}
