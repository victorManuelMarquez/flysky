package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Aeropuerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAeropuertoRepository extends JpaRepository<Aeropuerto,Long> {
}
