package ar.com.codoacodo.flysky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponseDto {

    private Long id;
    private String email;
    private String clave;

}
