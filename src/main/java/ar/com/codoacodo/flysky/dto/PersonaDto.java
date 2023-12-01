package ar.com.codoacodo.flysky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonaDto {

    private Long id;
    private String nombre;
    private String apellido;
    private int dni;
}
