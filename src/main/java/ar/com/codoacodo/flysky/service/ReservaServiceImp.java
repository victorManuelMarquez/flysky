package ar.com.codoacodo.flysky.service;


import ar.com.codoacodo.flysky.dto.ReservaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Reserva;
import ar.com.codoacodo.flysky.repository.IReservaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImp implements IReservaService {

    private IReservaRepository repository;

    public ReservaServiceImp(IReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarReserva(ReservaDto reservaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Reserva reserva = mapper.convertValue(reservaDto, Reserva.class);

        reserva = repository.save(reserva);

        if (reserva.getId() == null) {
            return new RespuestaDto("No se ha podido realizar la reserva, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Reserva realizada correctamente");
    }

    @Override
    public List<ReservaDto> listaReservas() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(reserva -> mapper.convertValue(reserva, ReservaDto.class)).toList();
    }

    @Override
    public ReservaDto buscarReservaPorId(Long id) {
        return null; // Implementar lógica para buscar una reserva por ID
    }

    @Override
    public RespuestaDto actualizarReservaPorId(Long id) {
        return null; // Implementar lógica para actualizar una reserva por ID
    }

    @Override
    public RespuestaDto borrarReservaPorId(Long id) {
        //hacer un try catch con exception

        //Si existe lo borro
        //if(respositry.existsById(id)){
        repository.deleteById(id);
        return new RespuestaDto("VReserva borrada");
        //}
    }
}

