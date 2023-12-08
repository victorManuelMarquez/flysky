package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.VueloDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Aerolinea;
import ar.com.codoacodo.flysky.entity.Aeropuerto;
import ar.com.codoacodo.flysky.entity.Vuelo;
import ar.com.codoacodo.flysky.repository.IVueloRepository;
import ar.com.codoacodo.flysky.service.interfaces.IVueloService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        ModelMapper mapper = new ModelMapper();

        Optional<Vuelo> vueloOptional = repository.findById(id);

        VueloDto respuesta = vueloOptional.map(vuelo -> mapper.map(vuelo, VueloDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarVueloPorId(Long id, VueloDto vueloDto) {
       //Vuelo vnew = repository.findById(id).orElse(null);
        Optional<Vuelo> vueloOptional = repository.findById(id);
        //if(vnew!=null){
            if (vueloOptional.isPresent()) {
                Vuelo vnew = vueloOptional.get();
                ModelMapper modelMapper = new ModelMapper();

                vnew.setAerolinea(modelMapper.map(vueloDto.getAerolinea(), Aerolinea.class));
                 //   vnew.setAerolinea(vueloDto.getAerolinea());
                vnew.setSalida(vueloDto.getSalida());
                vnew.setLlegada(vueloDto.getLlegada());
                vnew.setOrigen(modelMapper.map(vueloDto.getOrigen(), Aeropuerto.class));
                vnew.setDestino(modelMapper.map(vueloDto.getDestino(), Aeropuerto.class));

            repository.save(vnew);
            return new RespuestaDto("Vuelo actualizado correctamente");
        }
        else {
            return new RespuestaDto("No se encontró un vuelo con el ID proporcionado");
        }


    }

    @Override
    public RespuestaDto borrarVueloPorId(Long id) {

        //Para borrar el vuelo hay que asegurarse que no este asignado a ninguna reserva
        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Vuelo borrado");
        }else {
            return new RespuestaDto("No hay vuelo correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
