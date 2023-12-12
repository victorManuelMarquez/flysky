package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vuelos")
@SuppressWarnings("SpellCheckingInspection")
public class Vuelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_vuelo_aeropuerto_origen"))
    private Aeropuertos origen;

    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_vuelo_aeropuerto_destino"))
    private Aeropuertos destino;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_aerolinea"))
    private Aerolineas aerolinea;

    @Column(name = "salida", columnDefinition = "DATE")
    private LocalDate salida;

    @Column(name = "llegada", columnDefinition = "DATE")
    private LocalDate llegada;

}
