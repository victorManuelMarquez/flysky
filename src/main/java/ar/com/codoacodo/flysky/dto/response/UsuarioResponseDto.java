package ar.com.codoacodo.flysky.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String contraseña;

}
