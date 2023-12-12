package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajerosRepository extends JpaRepository<Pasajero, Integer> {
}
