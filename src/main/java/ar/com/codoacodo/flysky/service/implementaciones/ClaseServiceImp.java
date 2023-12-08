package ar.com.codoacodo.flysky.service.implementaciones;


import ar.com.codoacodo.flysky.dto.ClaseDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.*;
import ar.com.codoacodo.flysky.repository.IClaseRepository;
import ar.com.codoacodo.flysky.service.interfaces.IClaseService;
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
            return new RespuestaDto("No se ha podido cargar la clase, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Clase cargada correctamente");
    }

    @Override
    public List<ClaseDto> listaClases() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(clase -> mapper.convertValue(clase, ClaseDto.class)).toList();
    }

    @Override
    public ClaseDto buscarClasePorId(Long id) {
   // Implementar lógica para buscar una clase por ID
        ModelMapper mapper = new ModelMapper();

        Optional<Clase> claseOptional = repository.findById(id);

        return claseOptional.map(clase -> mapper.map(clase, ClaseDto.class)).orElse(null);

    }

    @Override
    public RespuestaDto actualizarClasePorId(Long id,ClaseDto claseDto) {
          Optional<Clase> claseOptional = repository.findById(id);

            if (claseOptional.isPresent()) {
                Clase cnew = claseOptional.get();
                ModelMapper modelMapper = new ModelMapper();

                cnew.setNombre(claseDto.getNombre());

                repository.save(cnew);
                return new RespuestaDto("Clase actualizada correctamente");
            } else {
                return new RespuestaDto("No se encontró una clase con el ID proporcionado");
            }


    }

    @Override
    public RespuestaDto borrarClasePorId(Long id) {
        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Clase borrada");
        }else {
            return new RespuestaDto("No hay una clase correspondiente a ese ID \nNo fue posible borrarlo");
        }
    }
}

