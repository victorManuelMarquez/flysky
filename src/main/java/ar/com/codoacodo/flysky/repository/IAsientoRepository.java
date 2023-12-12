package ar.com.codoacodo.flysky.repository;

import ar.com.codoacodo.flysky.model.entity.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< HEAD:src/main/java/ar/com/codoacodo/flysky/repository/IAsientoRepository.java
public interface IAsientoRepository extends JpaRepository<Asiento,Long> {
========
public interface VuelosRepository extends JpaRepository<Vuelo, Integer> {
>>>>>>>> db269efdddf305e63acb66105951da99a0ab8eeb:src/main/java/ar/com/codoacodo/flysky/repository/VuelosRepository.java
}
