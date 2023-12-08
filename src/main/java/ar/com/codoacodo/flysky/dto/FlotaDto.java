package ar.com.codoacodo.flysky.dto;

import ar.com.codoacodo.flysky.entity.Aerolinea;
import ar.com.codoacodo.flysky.entity.Avion;
import lombok.Data;

@Data
public class FlotaDto {

    private Long id;

    private Aerolinea  aerolinea;

    private Avion avion;
}
