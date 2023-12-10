package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.AeropuertoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertosRepository extends JpaRepository<AeropuertoEntity, Integer> {
}
