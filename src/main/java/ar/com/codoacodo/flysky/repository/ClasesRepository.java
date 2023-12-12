package ar.com.codoacodo.flysky.repository;

<<<<<<< HEAD
import ar.com.codoacodo.flysky.model.entity.Clases;
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/PagoRepository.java
import ar.com.codoacodo.flysky.entity.Pago;
========
import ar.com.codoacodo.flysky.model.entity.Clase;
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/ClasesRepository.java
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface ClasesRepository extends JpaRepository<Clases, Integer> {
=======
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/PagoRepository.java
public interface PagoRepository extends JpaRepository<Pago, Long> {
========
public interface ClasesRepository extends JpaRepository<Clase, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/ClasesRepository.java
>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb
}
