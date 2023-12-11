package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Aeronaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeronavesRepository extends JpaRepository<Aeronaves, Integer> {
}
