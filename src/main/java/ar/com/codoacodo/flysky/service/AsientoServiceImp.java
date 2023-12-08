package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.AsientoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.*;
import ar.com.codoacodo.flysky.repository.IAsientoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsientoServiceImp implements IAsientoService {

    private IAsientoRepository repository;

    public AsientoServiceImp(IAsientoRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarAsiento(AsientoDto asientoDto) {
        ObjectMapper mapper = new ObjectMapper();
        Asiento asiento = mapper.convertValue(asientoDto, Asiento.class);

        asiento = repository.save(asiento);

        if(asiento.getId() == null){
            return new RespuestaDto("No sea ha podido reservar el Asiento, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Asiento Reservado Correctamente");
    }

    @Override
    public List<AsientoDto> listaAsientos() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(asiento -> mapper.convertValue(asiento, AsientoDto.class)).toList();
    }

    @Override
    public AsientoDto buscarAsientoPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Asiento> asientoOptional = repository.findById(id);

        AsientoDto respuesta = asientoOptional.map(asiento -> mapper.map(asiento, AsientoDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarAsientoPorId(Long id, AsientoDto asientoDto) {
        Optional<Asiento> asientoOptional = repository.findById(id);

        if (asientoOptional.isPresent()) {
            Asiento anew = asientoOptional.get();
            ModelMapper modelMapper = new ModelMapper();

            // Verifica si el asientoDto no es nulo antes de mapear
            if (asientoDto.getClase() != null) {
                anew.setClase(modelMapper.map(asientoDto.getClase(), Clase.class));
            }

            anew.setPrecio(asientoDto.getPrecio());
            anew.setCantidad(asientoDto.getCantidad());

            repository.save(anew);
            return new RespuestaDto("Asiento actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Asiento con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarAsientoPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Asiento borrado");
        }else {
            return new RespuestaDto("No hay un asiento correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
