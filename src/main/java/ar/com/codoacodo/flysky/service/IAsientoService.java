package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Asiento;

import java.util.List;

public interface IAsientoService {

    RespuestaDto guardarVuelo(VueloDto vueloDto);

    List<VueloDto> listaVuelos();

    AsientoDto buscarVueloPorId(Long id);

    RespuestaDto actualizarVueloPorId(Long id, VueloDto vueloDto);

    RespuestaDto borrarVueloPorId(Long id);

    List<Asiento> listaAsientos();

    Asiento buscarAsientoPorId(Long id);

    Asiento guardarAsiento(Asiento asiento);

    Asiento actualizarAsientoPorId(Long id, Asiento asiento);

    void borrarAsientoPorId(Long id);
}
