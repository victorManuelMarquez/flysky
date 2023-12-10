package ar.com.codoacodo.flysky.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
@SuppressWarnings("SpellCheckingInspection")
public class DtoPasajero {

    @PositiveOrZero
    private Integer id;

    @NotBlank
    @Size(min = 6)
    @Size(max = 9)
    private String dni;

    @NotBlank
    @Size(max = 255)
    private String nombreCompleto;

    @NotBlank
    @Size(max = 255)
    private String domicilio;

    @Past
    private Date nacimiento;

    @Size(max = 255)
    private String email;

    @Size(max = 100)
    private String telefono;

}
