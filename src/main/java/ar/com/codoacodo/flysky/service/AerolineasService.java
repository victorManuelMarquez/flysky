package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAerolinea;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface AerolineasService {

    List<DtoAerolinea> todasLasAerolineas();

    DtoAerolinea buscarPorId(Integer id);

    DtoAerolinea agregarNueva(DtoAerolinea aerolinea);

    DtoAerolinea eliminar(Integer id);

}
