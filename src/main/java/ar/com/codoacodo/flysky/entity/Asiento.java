package ar.com.codoacodo.flysky.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Data

@Table(name = "asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
    private Clase clase;
    private double precio;
    private int cantidad;

}
