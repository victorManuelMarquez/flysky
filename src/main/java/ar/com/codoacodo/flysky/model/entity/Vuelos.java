package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vuelos")
@SuppressWarnings("SpellCheckingInspection")
public class Vuelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Aeropuertos.class)
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id")
    private Aeropuertos origen;

    @OneToOne(targetEntity = Aeropuertos.class)
    @JoinColumn(name = "id_aeropuerto_destino")
    private Aeropuertos destino;

    @OneToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolineas aerolineas;

    @Column(name = "salida", columnDefinition = "DATETIME")
    private LocalDate salida;

    @Column(name = "llegada", columnDefinition = "DATETIME")
    private LocalDate llegada;

}
