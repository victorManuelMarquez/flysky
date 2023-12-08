package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.ClasesPorAvion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClasesPorAvionRepository extends JpaRepository<ClasesPorAvion, Long> {
}
