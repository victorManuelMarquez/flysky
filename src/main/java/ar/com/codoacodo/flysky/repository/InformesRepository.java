package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Informe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformesRepository extends JpaRepository<Informe, Integer> {
}