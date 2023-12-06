package ar.com.codoacodo.flysky.entity;

<<<<<<< HEAD

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
=======
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
@Table(name = "asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
<<<<<<< HEAD
    @JoinColumn(name = "idClase", nullable = false)
    private Clase clase;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

=======
    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
    private Clase clase;
    private double precio;
    private int cantidad;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
