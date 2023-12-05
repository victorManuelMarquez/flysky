package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "flotas")
public class Flotas {


    @Id
    @ManyToOne
    @JoinColumn(name = "idAerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Id
    @ManyToOne
    @JoinColumn(name = "idAvion", nullable = false)
    private Avion avion;
}
