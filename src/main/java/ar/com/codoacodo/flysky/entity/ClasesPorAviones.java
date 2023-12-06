package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
=======
import lombok.Data;

@Entity
@Data
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
@Table(name = "clases_por_aviones")
public class ClasesPorAviones {

    @Id
<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "idAvion", nullable = false)
    private Avion avion;

    @Id
    @ManyToOne
    @JoinColumn(name = "idAsiento", nullable = false)
    private Asiento asiento;

}
=======
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_avion", foreignKey = @ForeignKey(name = "fk_clases_por_aviones__avion"))
    private Avion avion;

    @ManyToOne
    @JoinColumn(name = "id_asiento", foreignKey = @ForeignKey(name = "fk_clases_por_aviones__asiento"))
    private Asiento asiento;
}
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
