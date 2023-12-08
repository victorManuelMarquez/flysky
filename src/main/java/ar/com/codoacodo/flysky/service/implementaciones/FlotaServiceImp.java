package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.dto.FlotaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.*;
import ar.com.codoacodo.flysky.repository.IAsientoRepository;
import ar.com.codoacodo.flysky.repository.IFlotaRepository;
import ar.com.codoacodo.flysky.service.interfaces.IAsientoService;
import ar.com.codoacodo.flysky.service.interfaces.IFlotaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlotaServiceImp implements IFlotaService {

    private IFlotaRepository repository;

    public FlotaServiceImp(IFlotaRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarFlota(FlotaDto flotaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Flota flota = mapper.convertValue(flotaDto, Flota.class);

        flota = repository.save(flota);

        if(flota.getId() == null){
            return new RespuestaDto("No sea ha podido reservar el Asiento, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Asiento Reservado Correctamente");
    }

    @Override
    public List<FlotaDto> listaFlotas() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(flota -> mapper.convertValue(flota, FlotaDto.class)).toList();
    }

    @Override
    public FlotaDto buscarFlotaPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Flota> flotaOptional = repository.findById(id);

        FlotaDto respuesta = flotaOptional.map(flota -> mapper.map(flota, FlotaDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarFlotaPorId(Long id, FlotaDto flotaDto) {
        Optional<Flota> flotaOptional = repository.findById(id);

        if (flotaOptional.isPresent()) {
            Flota fnew = flotaOptional.get();
            ModelMapper modelMapper = new ModelMapper();

            // Verifica si la aerolineaDto no es nula antes de mapear
            if (flotaDto.getAerolinea() != null) {
                fnew.setAerolinea(modelMapper.map(flotaDto.getAerolinea(), Aerolinea.class));
            }

            // Verifica si el avionDto no es nulo antes de mapear
            if (flotaDto.getAvion() != null) {
                fnew.setAvion(modelMapper.map(flotaDto.getAvion(), Avion.class));
            }

            repository.save(fnew);
            return new RespuestaDto("Flota actualizada correctamente");
        } else {
            return new RespuestaDto("No se encontró una Flota con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarFlotaPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Flota borrada");
        }else {
            return new RespuestaDto("No hay una Flota correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
