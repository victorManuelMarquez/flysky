package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aeronaves")
@SuppressWarnings("SpellCheckingInspection")
public class Aeronave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_avion")
    private Avion avion;

    @OneToOne
    @JoinColumn(name = "id_clase")
    private Clase clase;

    @Column
    private Integer asientos;

}
