package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeronavesRepository extends JpaRepository<Aeronave, Integer> {
}
