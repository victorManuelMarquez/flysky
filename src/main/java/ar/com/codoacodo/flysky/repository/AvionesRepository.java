package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionesRepository extends JpaRepository<Avion, Integer> {
}
