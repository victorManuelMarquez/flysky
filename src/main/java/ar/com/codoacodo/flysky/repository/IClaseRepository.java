package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IClaseRepository.java
public interface IClaseRepository extends JpaRepository<Clase,Long> {
========
public interface PagosRepository extends JpaRepository<Pago, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/PagosRepository.java
}
