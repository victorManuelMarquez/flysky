package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "aviones")
public class Avion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @Column(name = "totalAsientos", nullable = false)
    private Integer totalAsientos;
=======
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
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
