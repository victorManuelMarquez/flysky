package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clases")
public class Clasea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
}
