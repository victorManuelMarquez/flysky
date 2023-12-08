package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.ClasesPorAvion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClasePorAvionesRepository extends JpaRepository<ClasesPorAvion, Long> {
}
