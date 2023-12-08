package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.ClasesPorAviones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClasePorAvionesRepository extends JpaRepository<ClasesPorAviones, Long> {
}
