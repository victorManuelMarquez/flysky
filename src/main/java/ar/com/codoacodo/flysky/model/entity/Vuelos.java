package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vuelos")
@SuppressWarnings("SpellCheckingInspection")
public class Vuelos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_aeropuerto_origen")
    private Aeropuertos origen;

    @OneToOne
    @JoinColumn(name = "id_aeropuerto_destino")
    private Aeropuertos destino;

    @OneToOne
    @JoinColumn(name = "id_aerolinea")
    private Aerolineas aerolineas;

    @Temporal(TemporalType.DATE)
    private Date salida;

    @Temporal(TemporalType.DATE)
    private Date llegada;

}
