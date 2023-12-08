package ar.com.codoacodo.flysky.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "asientos")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private Float precio;

    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
     private Clase clase;
/*
    @ManyToOne
    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
    private Clasea clasea;*/


    }
