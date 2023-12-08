package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Clasea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClaseaRepository extends JpaRepository<Clasea,Long> {
}
