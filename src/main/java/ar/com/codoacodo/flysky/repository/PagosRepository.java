package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends JpaRepository<Pago, Integer> {
}
