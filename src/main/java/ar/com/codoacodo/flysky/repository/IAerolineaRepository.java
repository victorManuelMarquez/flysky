package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAerolineaRepository extends JpaRepository<Aerolinea,Long>{
}
