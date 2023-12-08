package ar.com.codoacodo.flysky.dto.response;

import lombok.Data;

@Data
public class UsuarioResponseDto {

    private Long id;
    private String email;
    private String clave;

}
