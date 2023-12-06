package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Vuelo;
import ar.com.codoacodo.flysky.repository.IVueloRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VueloServiceImp implements IVueloService {

    private IVueloRepository repository;

    public VueloServiceImp (IVueloRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarVuelo(VueloDto vueloDto) {
        ObjectMapper mapper = new ObjectMapper();
        Vuelo vuelo = mapper.convertValue(vueloDto, Vuelo.class);

        vuelo = repository.save(vuelo);

        if(vuelo.getId() == null){
            return new RespuestaDto("No sea ha podido reservar el vuelo, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Vuelo Cargado Correctamente");
    }

    @Override
    public List<VueloDto> listaVuelos() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(vuelo -> mapper.convertValue(vuelo, VueloDto.class)).toList();
    }

    @Override
    public VueloDto buscarVueloPorId(Long id) {
        return null;
    }

    @Override
    public RespuestaDto actualizarVueloPorId(Long id) {
        return null;
    }

    @Override
    public RespuestaDto borrarVueloPorId(Long id) {

        //Para borrar el vuelo hay que asegurarse que no este asignado a ninguna reserva
        //hacer un try catch con exception

        //Si existe lo borro
        //if(respositry.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Vuelo borrado");
        //}



    }
}
