package ar.com.codoacodo.flysky.model.dto;

<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Aviones;
import ar.com.codoacodo.flysky.model.entity.Clases;
=======
import ar.com.codoacodo.flysky.model.entity.Avion;
import ar.com.codoacodo.flysky.model.entity.Clase;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
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

<<<<<<< HEAD
    private Aviones avion;

    private Clases clase;
=======
    private Avion avion;

    private Clase clase;
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb

    @Positive
    private Integer asientos;

}
