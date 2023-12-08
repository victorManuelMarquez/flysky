package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ClaseaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IClaseaService {
    RespuestaDto guardarClasea(ClaseaDto claseaDto);

    List<ClaseaDto> listaClasesa();

    ClaseaDto buscarClaseaPorId(Long id);

    ClaseaDto actualizarClaseaPorId(Long id, ClaseaDto claseaDto);

    RespuestaDto borrarClaseaPorId(Long id);
}
