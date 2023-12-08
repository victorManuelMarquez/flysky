package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.ClasesPorAvionDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Asiento;
import ar.com.codoacodo.flysky.entity.Avion;
import ar.com.codoacodo.flysky.entity.ClasesPorAvion;
import ar.com.codoacodo.flysky.repository.IClasesPorAvionRepository;
import ar.com.codoacodo.flysky.service.interfaces.IClasesPorAvionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasesPorAvionServiceImp implements IClasesPorAvionService {

    private IClasesPorAvionRepository repository;

    public ClasesPorAvionServiceImp(IClasesPorAvionRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarClasesPorAvion(ClasesPorAvionDto clasesPorAvionDto) {
        ObjectMapper mapper = new ObjectMapper();
        ClasesPorAvion clasesPorAvion = mapper.convertValue(clasesPorAvionDto, ClasesPorAvion.class);

        clasesPorAvion = repository.save(clasesPorAvion);

        if(clasesPorAvion.getId() == null){
            return new RespuestaDto("No sea ha podido guardar la clase del avion, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Clase Del Avion Guardada Correctamente");
    }

    @Override
    public List<ClasesPorAvionDto> listaClasesPorAviones() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(clasesPorAvion -> mapper.convertValue(clasesPorAvion, ClasesPorAvionDto.class)).toList();
    }

    @Override
    public ClasesPorAvionDto buscarClasesPorAvionPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<ClasesPorAvion> clasesPorAvionOptional = repository.findById(id);

        ClasesPorAvionDto respuesta = clasesPorAvionOptional.map(clasesPorAvion -> mapper.map(clasesPorAvion, ClasesPorAvionDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarClasesPorAvionPorId(Long id, ClasesPorAvionDto clasesPorAvionDto) {
        Optional<ClasesPorAvion> clasesPorAvionOptional = repository.findById(id);

        if (clasesPorAvionOptional.isPresent()) {
            ClasesPorAvion cnew = clasesPorAvionOptional.get();
            ModelMapper modelMapper = new ModelMapper();

            // Verifica si el avionDto no es nulo antes de mapear
            if (clasesPorAvionDto.getAvion() != null) {
                cnew.setAvion(modelMapper.map(clasesPorAvionDto.getAvion(), Avion.class));
            }

            // Verifica si el avionDto no es nulo antes de mapear
            if (clasesPorAvionDto.getAvion() != null) {
                cnew.setAsiento(modelMapper.map(clasesPorAvionDto.getAsiento(), Asiento.class));
            }

            repository.save(cnew);
            return new RespuestaDto("Asiento actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Asiento con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarClasesPorAvionPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Clases De Avion borrada");
        }else {
            return new RespuestaDto("No hay una clases de avion correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
