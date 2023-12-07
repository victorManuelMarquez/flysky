package ar.com.codoacodo.flysky.dto.response;

import lombok.Data;

@Data
public class ResponseUsuarioDto {
    private UsuarioResponseDto usuarioDto;
    private String message;
}
