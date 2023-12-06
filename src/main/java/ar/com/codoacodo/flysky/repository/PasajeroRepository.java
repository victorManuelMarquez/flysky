package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero,Long> {
}
