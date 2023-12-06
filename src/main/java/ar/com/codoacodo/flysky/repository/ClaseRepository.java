package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Long> {
}
