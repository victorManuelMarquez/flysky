package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "aviones")
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private int totalAsientos;

}
