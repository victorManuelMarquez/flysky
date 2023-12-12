package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.Aerolineas;
import ar.com.codoacodo.flysky.model.entity.Aeropuertos;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class DtoVuelo {

    @PositiveOrZero
    private Integer id;

    private Aeropuertos origen;

    private Aerolineas aerolinea;

    private Aeropuertos destino;

    private Date salida;

    private Date llegada;

}
