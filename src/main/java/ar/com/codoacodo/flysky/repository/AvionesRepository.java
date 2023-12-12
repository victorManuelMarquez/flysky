package ar.com.codoacodo.flysky.repository;

<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
import ar.com.codoacodo.flysky.model.entity.Aviones;
========
import ar.com.codoacodo.flysky.model.entity.Aeronave;
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AeronavesRepository.java
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IPagoRepository.java
import ar.com.codoacodo.flysky.entity.Pago;
========
import ar.com.codoacodo.flysky.model.entity.Avion;
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
public interface AvionesRepository extends JpaRepository<Aviones, Integer> {
========
public interface AeronavesRepository extends JpaRepository<Aeronave, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AeronavesRepository.java
}
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IPagoRepository.java
public interface IPagoRepository extends JpaRepository<Pago,Long> {
========
public interface AvionesRepository extends JpaRepository<Avion, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
}

>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
