package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ReservaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;

import java.util.List;

public interface IReservaService {
    RespuestaDto guardarReserva(ReservaDto reservaDto);

    List<ReservaDto> listaReservas();

    ReservaDto buscarReservaPorId(Long id);

    RespuestaDto actualizarReservaPorId(Long id,ReservaDto reservaDto);

    RespuestaDto borrarReservaPorId(Long id);
}
