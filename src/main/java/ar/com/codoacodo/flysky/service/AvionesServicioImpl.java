package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.AvionNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoAvion;
import ar.com.codoacodo.flysky.model.entity.Aviones;
import ar.com.codoacodo.flysky.repository.AvionesRepository;
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
@SuppressWarnings("SpellCheckingInspection")
public class AvionesServicioImpl implements AvionesServicio {

    @Autowired
    private AvionesRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoAvion> todosLosAviones() {
        List<DtoAvion> aviones = new ArrayList<>();
        repository.findAll().forEach(v -> aviones.add(getMapper().convertValue(v, DtoAvion.class)));
        return aviones;
    }

    @Override
    public DtoAvion buscarPorId(Integer id) {
        Optional<Aviones> aviones = repository.findById(id);
        if (aviones.isPresent())
            return getMapper().convertValue(aviones.get(), DtoAvion.class);
        else throw new AvionNoEncontrado();
    }

    @Override
    public DtoAvion agregarNuevo(DtoAvion avion) {
        Aviones aviones = repository.save(getMapper().convertValue(avion, Aviones.class));
        return getMapper().convertValue(aviones, DtoAvion.class);
    }

    @Override
    public DtoAvion eliminar(Integer id) {
        Optional<Aviones> aviones = repository.findById(id);
        if (aviones.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(aviones.get(), DtoAvion.class);
        } else throw new AvionNoEncontrado();
    }

}
