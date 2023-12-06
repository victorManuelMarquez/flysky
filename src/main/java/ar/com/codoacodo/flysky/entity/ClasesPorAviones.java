package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "clases_por_aviones")
public class ClasesPorAviones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_avion", foreignKey = @ForeignKey(name = "fk_clases_por_aviones__avion"))
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "id_asiento", foreignKey = @ForeignKey(name = "fk_clases_por_aviones__asiento"))
    private Asiento asiento;
}
