package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.PagoNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoPago;
import ar.com.codoacodo.flysky.model.entity.Pagos;
import ar.com.codoacodo.flysky.repository.PagosRepository;
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
public class PagosServiceImpl implements PagosService {

    @Autowired
    private PagosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoPago> todosLosPagos() {
        List<DtoPago> pagos = new ArrayList<>();
        repository.findAll().forEach(v -> pagos.add(getMapper().convertValue(v, DtoPago.class)));
        return pagos;
    }

    @Override
    public DtoPago buscarPorId(Integer id) {
        Optional<Pagos> pagos = repository.findById(id);
        if (pagos.isPresent())
            return getMapper().convertValue(pagos.get(), DtoPago.class);
        else throw new PagoNoEncontrado();
    }

    @Override
    public DtoPago agregarNuevo(DtoPago nuevo) {
        Pagos pagos = repository.save(getMapper().convertValue(nuevo, Pagos.class));
        return getMapper().convertValue(pagos.getId(), DtoPago.class);
    }

    @Override
    public DtoPago eliminar(Integer id) {
        Optional<Pagos> pagos = repository.findById(id);
        if (pagos.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(pagos.get(), DtoPago.class);
        } else throw new PagoNoEncontrado();
    }

}
