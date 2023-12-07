package ar.com.codoacodo.flysky.dto;

import lombok.Data;

@Data
public class UsuarioDto {

    private Long id;
    private String email;
    private String clave;
}
