package ar.com.codoacodo.flysky.model.dto;

import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Clase para transferir datos, en este caso los de la clase {@link ar.com.codoacodo.flysky.model.entity.Vuelo Vuelo}
 *
 * @author victor
 * @version 1.0
 * @since 1.0
 * @see ar.com.codoacodo.flysky.model.entity.Vuelo Entidad Vuelo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoVuelo {

    @PositiveOrZero
    private Integer id;

    private Aeropuerto origen;

    private Aerolinea aerolinea;

    private Aeropuerto destino;

    private Date salida;

    private Date llegada;

}
