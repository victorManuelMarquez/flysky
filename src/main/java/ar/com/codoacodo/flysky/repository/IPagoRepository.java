package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPagoRepository extends JpaRepository<Pago,Long> {
}

