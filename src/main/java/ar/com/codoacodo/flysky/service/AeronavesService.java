package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.model.dto.DtoAeronave;

import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public interface AeronavesService {

    List<DtoAeronave> todasLasAeronaves();

    String vincular(DtoAeronave relacion);

    DtoAeronave desvincular(DtoAeronave relacion);

}
