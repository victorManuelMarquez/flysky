package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.FlotaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IFlotaService {
//CRUD

    RespuestaDto guardarFlota(FlotaDto flotaDto);

    List<FlotaDto> listaFlotas();

    FlotaDto buscarFlotaPorId(Long id);

    RespuestaDto actualizarFlotaPorId(Long id, FlotaDto flotaDto);

    RespuestaDto borrarFlotaPorId(Long id);
}
