package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.AsientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientosRepository extends JpaRepository<AsientoEntity, Integer> {
}
