package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.VueloNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.model.entity.Vuelos;
import ar.com.codoacodo.flysky.repository.VuelosRepository;
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
public class VuelosServiceImpl implements VuelosService {

    @Autowired
    private VuelosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoVuelo> todosLosVuelos() {
        List<DtoVuelo> vuelos = new ArrayList<>();
        repository.findAll().forEach(v -> vuelos.add(getMapper().convertValue(v, DtoVuelo.class)));
        return vuelos;
    }

    @Override
    public DtoVuelo buscarPorId(Integer id) {
        Optional<Vuelos> vuelos = repository.findById(id);
        if (vuelos.isPresent())
            return getMapper().convertValue(vuelos.get(), DtoVuelo.class);
        else throw new VueloNoEncontrado();
    }

    @Override
    public DtoVuelo agregarVuelo(DtoVuelo nuevo) {
        Vuelos vuelos = repository.save(getMapper().convertValue(nuevo, Vuelos.class));
        return getMapper().convertValue(vuelos, DtoVuelo.class);
    }

    @Override
    public DtoVuelo eliminar(Integer id) {
        Optional<Vuelos> vuelos = repository.findById(id);
        if (vuelos.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(vuelos.get(), DtoVuelo.class);
        } else throw new VueloNoEncontrado();
    }

}
