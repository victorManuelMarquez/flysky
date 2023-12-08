package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IAsientoService {

    RespuestaDto guardarAsiento(AsientoDto asientoDto);

    List<AsientoDto> listaAsientos();

    AsientoDto buscarAsientoPorId(Long id);

    RespuestaDto actualizarAsientoPorId(Long id, AsientoDto asientoDto);

    RespuestaDto borrarAsientoPorId(Long id);



}
