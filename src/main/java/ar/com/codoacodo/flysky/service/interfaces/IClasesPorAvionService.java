package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.ClasesPorAvionDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IClasesPorAvionService {
//CRUD

    RespuestaDto guardarClasesPorAvion(ClasesPorAvionDto clasesPorAvionDto);

    List<ClasesPorAvionDto> listaClasesPorAviones();

    ClasesPorAvionDto buscarClasesPorAvionPorId(Long id);

    RespuestaDto actualizarClasesPorAvionPorId(Long id, ClasesPorAvionDto clasesPorAvionDto);

    RespuestaDto borrarClasesPorAvionPorId(Long id);
}
