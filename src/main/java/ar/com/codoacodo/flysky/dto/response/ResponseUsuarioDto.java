package ar.com.codoacodo.flysky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseUsuarioDto {
    private UsuarioResponseDto usuarioDto;
    private String message;
}
