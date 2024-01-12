package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que permite modelar los datos de la tabla {@code aeropuertos}
 *
 * @author victor
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String ciudad;

//    @ManyToOne(targetEntity = Vuelos.class)
//    private Vuelos vueloOrigen;
//
//    @ManyToOne(targetEntity = Vuelos.class)
//    private Vuelos vueloDestino;

}
