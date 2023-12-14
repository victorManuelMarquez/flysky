package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aeropuertos")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String ciudad;



//    @ManyToOne(targetEntity = Vuelos.class)
//    private Vuelos vueloOrigen;
//
//    @ManyToOne(targetEntity = Vuelos.class)
//    private Vuelos vueloDestino;

}
