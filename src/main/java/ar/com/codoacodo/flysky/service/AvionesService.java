package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAvion;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface AvionesService {

    List<DtoAvion> todosLosAviones();

    DtoAvion buscarPorId(Integer id);

    String agregarAvion(DtoAvion nuevo);

    DtoAvion eliminar(Integer id);

}
