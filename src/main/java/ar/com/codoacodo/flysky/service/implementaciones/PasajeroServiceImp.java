package ar.com.codoacodo.flysky.service.implementaciones;

import ar.com.codoacodo.flysky.dto.AerolineaDto;
import ar.com.codoacodo.flysky.dto.PasajeroDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Aerolinea;
import ar.com.codoacodo.flysky.entity.Pasajero;
import ar.com.codoacodo.flysky.repository.IAerolineaRepository;
import ar.com.codoacodo.flysky.repository.IPasajeroRepository;
import ar.com.codoacodo.flysky.service.interfaces.IAerolineaService;
import ar.com.codoacodo.flysky.service.interfaces.IPasajeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroServiceImp implements IPasajeroService {

    private IPasajeroRepository repository;

    public PasajeroServiceImp(IPasajeroRepository repository){
        this.repository = repository;
    }

    @Override
    public RespuestaDto guardarPasajero(PasajeroDto pasajeroDto) {
        ObjectMapper mapper = new ObjectMapper();
        Pasajero pasajero = mapper.convertValue(pasajeroDto, Pasajero.class);

        pasajero = repository.save(pasajero);

        if(pasajero.getId() == null){
            return new RespuestaDto("No sea ha podido guardar el pasajero, por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Pasajero Guardado Correctamente");
    }

    @Override
    public List<PasajeroDto> listaPasajeros() {
        ObjectMapper mapper = new ObjectMapper();
        return repository.findAll().stream().map(pasajero -> mapper.convertValue(pasajero, PasajeroDto.class)).toList();
    }

    @Override
    public PasajeroDto buscarPasajeroPorId(Long id) {
        ModelMapper mapper = new ModelMapper();

        Optional<Pasajero> pasajeroOptional = repository.findById(id);

        PasajeroDto respuesta = pasajeroOptional.map(pasajero -> mapper.map(pasajero, PasajeroDto.class)).orElse(null);

        return respuesta;
    }

    @Override
    public RespuestaDto actualizarPasajeroPorId(Long id, PasajeroDto pasajeroDto) {
        Optional<Pasajero> pasajeroOptional = repository.findById(id);

        if (pasajeroOptional.isPresent()) {
            Pasajero pnew = pasajeroOptional.get();

            pnew.setDni(pasajeroDto.getDni());
            pnew.setNombres(pasajeroDto.getNombres());
            pnew.setApellidos(pasajeroDto.getApellidos());
            pnew.setTelefono(pasajeroDto.getTelefono());
            pnew.setEmail(pasajeroDto.getEmail());

            repository.save(pnew);
            return new RespuestaDto("Pasajero actualizado correctamente");
        } else {
            return new RespuestaDto("No se encontró un Pasajero con el ID proporcionado");
        }
    }

    @Override
    public RespuestaDto borrarPasajeroPorId(Long id) {

        //hacer un try catch con exception

        //Si existe lo borro
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new RespuestaDto("Pasajero borrado");
        }else {
            return new RespuestaDto("No hay un Pasajero correspondiente a ese ID \nNo fue posible borrarlo");
        }



    }
}
