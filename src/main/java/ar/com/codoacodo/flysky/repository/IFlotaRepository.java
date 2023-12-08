package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Flota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFlotaRepository extends JpaRepository<Flota, Long> {
}
