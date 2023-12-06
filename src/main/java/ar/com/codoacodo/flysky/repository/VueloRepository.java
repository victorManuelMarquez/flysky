package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo,Long> {
}
