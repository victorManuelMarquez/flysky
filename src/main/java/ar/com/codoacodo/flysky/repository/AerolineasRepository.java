package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("SpellCheckingInspection")
public interface AerolineasRepository extends JpaRepository<Aerolinea, Integer> {
}
