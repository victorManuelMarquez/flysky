package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que permite modelar los datos de la tabla {@code aviones}.
 *
 * @author victor, Fede
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aviones")
@SuppressWarnings("SpellCheckingInspection")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "marca_modelo")
    private String marcaModelo;

}
