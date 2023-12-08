package ar.com.codoacodo.flysky.dto;

import ar.com.codoacodo.flysky.entity.Asiento;
import ar.com.codoacodo.flysky.entity.Avion;
import lombok.Data;

@Data
public class ClasesPorAvionesDto {

    private  Long id;

    private Avion avion;

    private Asiento asiento;
}
