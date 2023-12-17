package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Pago;
import ar.com.codoacodo.flysky.model.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagosRepository extends JpaRepository<Pago, Integer> {
    List<Pago> findByPasajero(Pasajero pasajero);
}
