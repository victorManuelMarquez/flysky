package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.PagoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

public interface IPagoService {

    RespuestaDto procesarPago(PagoDto pagoDto);
}
