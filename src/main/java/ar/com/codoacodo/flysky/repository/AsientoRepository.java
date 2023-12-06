package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento,Long> {
}
