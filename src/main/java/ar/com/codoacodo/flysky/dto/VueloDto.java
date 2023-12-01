package ar.com.codoacodo.flysky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VueloDto {

    private Long id;
    private String aerolinea;
    private Long precio;
    private Date salida;
    private String origen;
    private Date llegada;
    private String destino;
}
