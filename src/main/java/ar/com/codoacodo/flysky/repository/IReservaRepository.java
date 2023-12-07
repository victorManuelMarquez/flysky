package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva,Long> {
}
