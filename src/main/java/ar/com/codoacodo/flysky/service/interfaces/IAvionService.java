package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.AvionDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IAvionService {
//CRUD

    RespuestaDto guardarAvion(AvionDto avionDto);

    List<AvionDto> listaAviones();

    AvionDto buscarAvionPorId(Long id);

    RespuestaDto actualizarAvionPorId(Long id, AvionDto avionDto);

    RespuestaDto borrarAvionPorId(Long id);
}
