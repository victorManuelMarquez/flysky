package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.BoletoNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoBoleto;
import ar.com.codoacodo.flysky.model.entity.Boleto;
import ar.com.codoacodo.flysky.repository.BoletosRepository;
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
public class BoletosServiceImpl implements BoletosService {

    @Autowired
    private BoletosRepository repository;

    private ObjectMapper mapper;

    @Override
    public List<DtoBoleto> todosLosBoletos() {
        List<DtoBoleto> boletos = new ArrayList<>();
        repository.findAll().forEach(v -> boletos.add(getMapper().convertValue(v, DtoBoleto.class)));
        return boletos;
    }

    @Override
    public DtoBoleto buscarPorId(Integer id) {
        Optional<Boleto> boletos = repository.findById(id);
        if (boletos.isPresent())
            return getMapper().convertValue(boletos.get(), DtoBoleto.class);
        else throw new BoletoNoEncontrado();
    }

    @Override
    public DtoBoleto agregarBoleto(DtoBoleto nuevo) {
        Boleto boleto = repository.save(getMapper().convertValue(nuevo, Boleto.class));
        return getMapper().convertValue(boleto, DtoBoleto.class);
    }

    @Override
    public DtoBoleto eliminar(Integer id) {
        Optional<Boleto> boletos = repository.findById(id);
        if (boletos.isPresent()) {
            repository.deleteById(id);
            return getMapper().convertValue(boletos.get(), DtoBoleto.class);
        } else throw new BoletoNoEncontrado();
    }

}
