package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "boletos")
public class Boletos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_vuelo")
    private Vuelos vuelo;

    @OneToOne
    @JoinColumn(name = "id_aeronave")
    private Aeronaves aeronave;

    @Column
    private Float precio;

    @Column(name = "reserva", columnDefinition = "DATETIME")
    private LocalDate reserva;

}
