package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
/**
 * Clase que permite modelar los datos de la tabla {@code boletos}
 *
 * @author victor
 * @version 1.0
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "boletos")
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelo vuelo;

    @OneToOne
    @JoinColumn(name = "id_aeronave")
    private Aeronave aeronave;

    @Column
    private Float precio;

    @Column(name = "reserva", columnDefinition = "DATETIME")
    private LocalDate reserva;

}
