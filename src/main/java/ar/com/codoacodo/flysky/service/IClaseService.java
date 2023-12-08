package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClaseService {
    RespuestaDto guardarClase(ClaseDto claseDto);

    List<ClaseDto> listaClases();

    ClaseDto buscarClasePorId(Long id);

    ClaseDto actualizarClasePorId(Long id, ClaseDto claseDto);;

    RespuestaDto borrarClasePorId(Long id);

}
