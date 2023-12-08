package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.AeropuertoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Aeropuerto;
import ar.com.codoacodo.flysky.repository.IAeropuertoRepository;
import ar.com.codoacodo.flysky.service.interfaces.IAeropuertoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AeropuertoServiceImp implements IAeropuertoService {

    private IAeropuertoRepository repository;

    public AeropuertoServiceImp(IAeropuertoRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarAeropuerto(AeropuertoDto aeropuertoaDto) {
        ObjectMapper mapper = new ObjectMapper();
        Aeropuerto aeropuerto = mapper.convertValue(aeropuertoaDto, Aeropuerto.class);

        aeropuerto = repository.save(aeropuerto);

        if(aeropuerto.getId() == null){
            return new RespuestaDto("No sea ha podido guardar el aeropuerto, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Aeropuerto guardado Correctamente");
    }

    @Override
    public List<AeropuertoDto> listaAeropuertos() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(aeropuerto -> mapper.convertValue(aeropuerto, AeropuertoDto.class)).toList();
    }

    @Override
    public AeropuertoDto buscarAeropuertoPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Aeropuerto> aeropuertoOptional = repository.findById(id);

        AeropuertoDto respuesta = aeropuertoOptional.map(aeropuerto -> mapper.map(aeropuerto, AeropuertoDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarAeropuertoPorId(Long id, AeropuertoDto aeropuertoDto) {
        Optional<Aeropuerto> aeropuertoOptional = repository.findById(id);

        if (aeropuertoOptional.isPresent()) {
            Aeropuerto anew = aeropuertoOptional.get();

            anew.setNombre(aeropuertoDto.getNombre());
            anew.setCiudad(aeropuertoDto.getCiudad());

            repository.save(anew);
            return new RespuestaDto("Aeropuerto actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Aeropuerto con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarAeropuertoPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Aeropuerto borrado");
        }else {
            return new RespuestaDto("No hay un Aeropuerto correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
