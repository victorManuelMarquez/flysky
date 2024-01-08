package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Clase que permite modelar la tabla {@code vuelos}, la cual posee 3 cláves foráneas.
 *
 * @author victor, Fede
 * @version 1.0
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vuelos")
@SuppressWarnings("SpellCheckingInspection")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Aeropuerto.class)
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id")
    private Aeropuerto origen;

    @OneToOne(targetEntity = Aeropuerto.class)
    @JoinColumn(name = "id_aeropuerto_destino")
    private Aeropuerto destino;

    @OneToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolinea aerolinea;

    @Column(name = "salida", columnDefinition = "DATETIME")
    private LocalDate salida;

    @Column(name = "llegada", columnDefinition = "DATETIME")
    private LocalDate llegada;

}
