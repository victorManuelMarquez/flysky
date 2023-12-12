package ar.com.codoacodo.flysky.repository;

<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Aeronaves;
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
import ar.com.codoacodo.flysky.model.entity.Aviones;
========
import ar.com.codoacodo.flysky.model.entity.Aeronave;
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AeronavesRepository.java
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface AeronavesRepository extends JpaRepository<Aeronaves, Integer> {
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/AvionesRepository.java
public interface AvionesRepository extends JpaRepository<Aviones, Integer> {
========
public interface AeronavesRepository extends JpaRepository<Aeronave, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/AeronavesRepository.java
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
}
