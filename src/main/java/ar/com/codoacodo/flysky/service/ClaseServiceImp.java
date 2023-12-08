package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Clase;
import ar.com.codoacodo.flysky.repository.IClaseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseServiceImp implements IClaseService {
    private IClaseRepository repository;

    public ClaseServiceImp(IClaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarClase(ClaseDto claseDto) {
        ObjectMapper mapper = new ObjectMapper();
        Clase clase = mapper.convertValue(claseDto, Clase.class);
        clase = repository.save(clase);
        if (clase.getId() == null) {
            return new RespuestaDto("No se ha podido guardar la clase, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Clase guardada correctamente");
    }

    @Override
    public List<ClaseDto> listaClases() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(clase -> mapper.convertValue(clase, ClaseDto.class)).toList();
    }

    @Override
    public ClaseDto buscarClasePorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Clase> claseOptional = repository.findById(id);

        return claseOptional.map(clase -> mapper.map(clase, ClaseDto.class)).orElse(null);
    }

    @Override
    public ClaseDto actualizarClasePorId(Long id, ClaseDto claseDto) {
        Optional<Clase> claseOptional = repository.findById(id);

        if (claseOptional.isPresent()) {
            Clase clase = claseOptional.get();
            ModelMapper modelMapper = new ModelMapper();

            clase.setNombre(claseDto.getNombre());

            repository.save(clase);
            return modelMapper.map(clase, ClaseDto.class);
        } else {
            return null; // o manejar de otra manera si la clase no se encuentra
        }
    }

    @Override
    public RespuestaDto borrarClasePorId(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return new RespuestaDto("Clase borrada");
        } else {
            return new RespuestaDto("No hay clase correspondiente a ese ID \nNo fue posible borrarla");
        }
    }
}
