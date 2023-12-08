package ar.com.codoacodo.flysky.service.interfaces;

import ar.com.codoacodo.flysky.dto.AeropuertoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IAeropuertoService {
//CRUD

    RespuestaDto guardarAeropuerto(AeropuertoDto aeropuertoDto);

    List<AeropuertoDto> listaAeropuertos();

    AeropuertoDto buscarAeropuertoPorId(Long id);

    RespuestaDto actualizarAeropuertoPorId(Long id, AeropuertoDto aeropuertoDto);

    RespuestaDto borrarAeropuertoPorId(Long id);
}
