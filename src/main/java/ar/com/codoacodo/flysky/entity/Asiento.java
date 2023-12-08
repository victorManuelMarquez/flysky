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

    @Column(name = "id_clase")
    private Long id_clase;

    @Column(name = "precio")
    private Float precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_clase", insertable = false, updatable = false)
    private Clase clase;
/*
    @ManyToOne
    @JoinColumn(name = "id_clase", foreignKey = @ForeignKey(name = "fk_asientos_clase"))
    private Clasea clasea;*/


    }
