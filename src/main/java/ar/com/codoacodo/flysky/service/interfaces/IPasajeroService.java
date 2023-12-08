package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.PasajeroDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IPasajeroService {
//CRUD

    RespuestaDto guardarPasajero(PasajeroDto pasajeroDto);

    List<PasajeroDto> listaPasajeros();

    PasajeroDto buscarPasajeroPorId(Long id);

    RespuestaDto actualizarPasajeroPorId(Long id, PasajeroDto pasajeroDto);

    RespuestaDto borrarPasajeroPorId(Long id);
}
