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
    @JoinColumn(name = "id_aerolinea", nullable = false)
    private Aerolinea aerolinea;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_avion", nullable = false)
    private Avion avion;


}
