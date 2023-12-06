package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "flotas")
public class Flota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", foreignKey = @ForeignKey(name = "fk_flotas_aerolinea"))
    private Aerolinea aerolinea;

    @ManyToOne
    @JoinColumn(name = "id_avion", foreignKey = @ForeignKey(name = "fk_flotas_avion"))
    private Avion avion;
}
