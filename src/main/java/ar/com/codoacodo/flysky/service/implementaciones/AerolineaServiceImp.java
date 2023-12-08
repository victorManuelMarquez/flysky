package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Aerolinea;
import ar.com.codoacodo.flysky.repository.IAerolineaRepository;
import ar.com.codoacodo.flysky.service.interfaces.IAerolineaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AerolineaServiceImp implements IAerolineaService {

    private IAerolineaRepository repository;

    public AerolineaServiceImp(IAerolineaRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarAerolinea(AerolineaDto aerolineaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Aerolinea aerolinea = mapper.convertValue(aerolineaDto, Aerolinea.class);

        aerolinea = repository.save(aerolinea);

        if(aerolinea.getId() == null){
            return new RespuestaDto("No sea ha podido guardar la aerolinea, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Aerolinea Reservada Correctamente");
    }

    @Override
    public List<AerolineaDto> listaAerolineas() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(aerolinea -> mapper.convertValue(aerolinea, AerolineaDto.class)).toList();
    }

    @Override
    public AerolineaDto buscarAerolineaPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Aerolinea> aerolineaOptional = repository.findById(id);

        AerolineaDto respuesta = aerolineaOptional.map(aerolinea -> mapper.map(aerolinea, AerolineaDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarAerolineaPorId(Long id, AerolineaDto aerolineaDto) {
        Optional<Aerolinea> aerolineaOptional = repository.findById(id);

        if (aerolineaOptional.isPresent()) {
            Aerolinea anew = aerolineaOptional.get();

            anew.setNombre(aerolineaDto.getNombre());

            repository.save(anew);
            return new RespuestaDto("Aerolinea actualizada correctamente");
        } else {
            return new RespuestaDto("No se encontró una Aerolinea con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarAerolineaPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Aerolinea borrado");
        }else {
            return new RespuestaDto("No hay una Aerolinea correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
