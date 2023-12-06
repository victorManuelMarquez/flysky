package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionRepository extends JpaRepository<Avion,Long> {
}
