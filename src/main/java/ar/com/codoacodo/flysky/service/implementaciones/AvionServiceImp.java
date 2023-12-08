package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.AvionDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Avion;
import ar.com.codoacodo.flysky.repository.IAvionRepository;
import ar.com.codoacodo.flysky.service.interfaces.IAvionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvionServiceImp implements IAvionService {

    private IAvionRepository repository;

    public AvionServiceImp(IAvionRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarAvion(AvionDto avionDto) {
        ObjectMapper mapper = new ObjectMapper();
        Avion avion = mapper.convertValue(avionDto, Avion.class);

        avion = repository.save(avion);

        if(avion.getId() == null){
            return new RespuestaDto("No sea ha podido guardar el avion, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Avion guardado Correctamente");
    }

    @Override
    public List<AvionDto> listaAviones() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(avion -> mapper.convertValue(avion, AvionDto.class)).toList();
    }

    @Override
    public AvionDto buscarAvionPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Avion> avionOptional = repository.findById(id);

        AvionDto respuesta = avionOptional.map(avion -> mapper.map(avion, AvionDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarAvionPorId(Long id, AvionDto avionDto) {
        Optional<Avion> avionOptional = repository.findById(id);

        if (avionOptional.isPresent()) {
            Avion anew = avionOptional.get();

            anew.setModelo(avionDto.getModelo());
            anew.setTotalAsientos(avionDto.getTotalAsientos());

            repository.save(anew);
            return new RespuestaDto("Avion actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Avion con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarAvionPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Avion borrado");
        }else {
            return new RespuestaDto("No hay un Avion correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
