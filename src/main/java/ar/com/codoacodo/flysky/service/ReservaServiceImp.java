package ar.com.codoacodo.flysky.service;


import ar.com.codoacodo.flysky.dto.ReservaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Pasajero;
import ar.com.codoacodo.flysky.entity.Reserva;
import ar.com.codoacodo.flysky.entity.Usuario;
import ar.com.codoacodo.flysky.entity.Vuelo;
import ar.com.codoacodo.flysky.repository.IReservaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
   // Implementar lógica para buscar una reserva por ID
        ModelMapper mapper = new ModelMapper();

        Optional<Reserva> reservaOptional = repository.findById(id);

        return reservaOptional.map(reserva -> mapper.map(reserva, ReservaDto.class)).orElse(null);

    }

    @Override
    public RespuestaDto actualizarReservaPorId(Long id,ReservaDto reservaDto) {
          Optional<Reserva> reservaOptional = repository.findById(id);

            if (reservaOptional.isPresent()) {
                Reserva rnew = reservaOptional.get();
                ModelMapper modelMapper = new ModelMapper();

                // Verifica si el UsuarioDto no es nulo antes de mapear
                if (reservaDto.getUsuario() != null) {
                    rnew.setUsuario(modelMapper.map(reservaDto.getUsuario(), Usuario.class));
                }

                // Verifica si el VueloDto no es nulo antes de mapear
                if (reservaDto.getVuelo() != null) {
                    rnew.setVuelo(modelMapper.map(reservaDto.getVuelo(), Vuelo.class));
                }

                // Verifica si el PasajeroDto no es nulo antes de mapear
                if (reservaDto.getPasajero() != null) {
                    rnew.setPasajero(modelMapper.map(reservaDto.getPasajero(), Pasajero.class));
                }

                rnew.setFechaReserva(reservaDto.getFechaReserva());
                rnew.setComprobante(reservaDto.getComprobante());
                rnew.setCancelada(reservaDto.getCancelada());

                repository.save(rnew);
                return new RespuestaDto("Reserva actualizada correctamente");
            } else {
                return new RespuestaDto("No se encontró una reserva con el ID proporcionado");
            }


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

