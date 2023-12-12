package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Boletos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoletosRepository extends JpaRepository<Boletos, Integer> {
}
