package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IAerolineaService {
//CRUD

    RespuestaDto guardarAerolinea(AerolineaDto aerolineaDto);

    List<AerolineaDto> listaAerolineas();

    AerolineaDto buscarAerolineaPorId(Long id);

    RespuestaDto actualizarAerolineaPorId(Long id, AerolineaDto aerolineaDto);

    RespuestaDto borrarAerolineaPorId(Long id);
}
