package ar.com.codoacodo.flysky.model.dto;

<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Aerolineas;
import ar.com.codoacodo.flysky.model.entity.Aeropuertos;
=======
import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
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

<<<<<<< HEAD
    private Aeropuertos origen;

    private Aerolineas aerolinea;

    private Aeropuertos destino;
=======
    private Aeropuerto origen;

    private Aerolinea aerolinea;

    private Aeropuerto destino;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb

    private Date salida;

    private Date llegada;

}
