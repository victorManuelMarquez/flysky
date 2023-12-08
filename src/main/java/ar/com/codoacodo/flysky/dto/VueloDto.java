package ar.com.codoacodo.flysky.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class VueloDto {

    private Long id;
    private AerolineaDto aerolinea;
    private Date salida;
    private Date llegada;

    private AeropuertoDto origen;
    private AeropuertoDto destino;
}
