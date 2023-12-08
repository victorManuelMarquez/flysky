package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clasesa")
public class Clasea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
