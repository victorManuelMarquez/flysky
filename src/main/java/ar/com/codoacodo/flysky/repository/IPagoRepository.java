package ar.com.codoacodo.flysky.repository;

<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IPagoRepository.java
import ar.com.codoacodo.flysky.entity.Pago;
========
import ar.com.codoacodo.flysky.model.entity.Avion;
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IPagoRepository.java
public interface IPagoRepository extends JpaRepository<Pago,Long> {
========
public interface AvionesRepository extends JpaRepository<Avion, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
}

