package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoClase;

import java.util.List;

public interface ClasesService {

    List<DtoClase> todasLasClases();

    DtoClase buscarPorId(Integer id);

    String agregarNueva(DtoClase nueva);

    DtoClase eliminar(Integer id);

}
