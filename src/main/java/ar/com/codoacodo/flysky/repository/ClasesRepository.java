package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasesRepository extends JpaRepository<Clase, Integer> {
}
