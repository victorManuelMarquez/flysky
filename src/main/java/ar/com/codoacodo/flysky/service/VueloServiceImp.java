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

        repository.save(vuelo);

        if(vuelo == null){
            return new RespuestaDto("No sea ha podido reservar el vuelo, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Vuelo Cargado Correctamente");
    }

    @Override
    public List<VueloDto> listaVuelo() {
        return null;
    }
}
