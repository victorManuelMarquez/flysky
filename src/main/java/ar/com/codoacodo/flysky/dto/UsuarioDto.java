package ar.com.codoacodo.flysky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDto {

    private Long id;
    private String email;
    private String clave;
}
