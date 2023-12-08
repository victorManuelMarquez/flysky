package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IClaseService {
    RespuestaDto guardarClase(ClaseDto claseDto);

    List<ClaseDto> listaClases();

    ClaseDto buscarClasePorId(Long id);

    RespuestaDto actualizarClasePorId(Long id,ClaseDto claseDto);

    RespuestaDto borrarClasePorId(Long id);
}
