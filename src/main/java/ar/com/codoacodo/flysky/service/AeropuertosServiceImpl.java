package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AeronaveNoEncontrada;
import ar.com.codoacodo.flysky.exception.AeropuertoNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoAeronave;
import ar.com.codoacodo.flysky.model.dto.DtoAeropuerto;
import ar.com.codoacodo.flysky.model.entity.Aeronave;
import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import ar.com.codoacodo.flysky.repository.AeropuertosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class AeropuertosServiceImpl implements AeropuertosService {

    @Autowired
    private AeropuertosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoAeropuerto> todosLosAeropuertos() {
        List<DtoAeropuerto> aeropuertos = new ArrayList<>();
        repository.findAll().forEach(v -> aeropuertos.add(getMapper().convertValue(v, DtoAeropuerto.class)));
        return aeropuertos;
    }

    @Override
    public DtoAeropuerto buscarPorId(Integer id) {
        //return getMapper().convertValue(repository.findById(id), DtoAeropuerto.class);
        Optional<Aeropuerto> aeropuerto = repository.findById(id);
        if (aeropuerto.isPresent())
            return getMapper().convertValue(aeropuerto.get(), DtoAeropuerto.class);
        else throw new AeropuertoNoEncontrado();
    }

    @Override
    public DtoAeropuerto agregarNuevo(DtoAeropuerto aeropuerto) {
        Aeropuerto aeropuertos = repository.save(getMapper().convertValue(aeropuerto, Aeropuerto.class));
        return getMapper().convertValue(aeropuertos, DtoAeropuerto.class);
    }

    @Override
    public DtoAeropuerto eliminar(Integer id) {
        Optional<Aeropuerto> aeropuertos = repository.findById(id);
        if (aeropuertos.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aeropuertos.get(), DtoAeropuerto.class);
        } else throw new AeropuertoNoEncontrado();
    }

}
