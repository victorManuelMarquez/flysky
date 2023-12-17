package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoInforme;

import java.util.List;

public interface InformesService {

    List<DtoInforme> todosLosInformes();

    DtoInforme buscarPorId(Integer id);

    DtoInforme agregarNuevo(DtoInforme nuevo);

    DtoInforme eliminar(Integer id);

    void calcularDestinoMasFrecuente();
}
