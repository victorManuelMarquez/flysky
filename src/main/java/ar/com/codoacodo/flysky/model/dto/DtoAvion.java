package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase para transferir datos, en este caso de la clase {@link ar.com.codoacodo.flysky.model.entity.Avion Avion}.
 *
 * @author victor
 * @version 1.0
 * @since 1.0
 * @see ar.com.codoacodo.flysky.model.entity.Avion Entidad Avión
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class DtoAvion {

    @PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String marcaModelo;

}
