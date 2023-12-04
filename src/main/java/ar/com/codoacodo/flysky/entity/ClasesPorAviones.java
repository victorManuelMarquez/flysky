package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "clases_por_aviones")
public class ClasesPorAviones {

    @Id
    @ManyToOne
    @JoinColumn(name = "idAvion", nullable = false)
    private Avion avion;

    @Id
    @ManyToOne
    @JoinColumn(name = "idAsiento", nullable = false)
    private Asiento asiento;


}