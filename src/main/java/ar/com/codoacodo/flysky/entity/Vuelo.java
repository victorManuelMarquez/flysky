package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", foreignKey = @ForeignKey(name = "fk_vuelos_aerolinea"))
    private Aerolinea aerolinea;
    private Date salida;
    private Date llegada;

    @ManyToOne
    @JoinColumn(name = "id_origen", foreignKey = @ForeignKey(name = "fk_vuelos_origen"))
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "id_destino", foreignKey = @ForeignKey(name = "fk_vuelos_destino"))
    private Aeropuerto destino;
}
