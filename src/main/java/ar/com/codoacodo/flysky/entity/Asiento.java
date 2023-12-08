package ar.com.codoacodo.flysky.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
    private Clasea clasea;

    private double precio;
    private int cantidad;
}
