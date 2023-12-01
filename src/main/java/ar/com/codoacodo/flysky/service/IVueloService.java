package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IVueloService {
//CRUD

    RespuestaDto guardarVuelo(VueloDto vueloDto);

    List<VueloDto> listaVuelo();

}
