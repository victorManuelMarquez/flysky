package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertosRepository extends JpaRepository<Aeropuerto, Integer> {
}
