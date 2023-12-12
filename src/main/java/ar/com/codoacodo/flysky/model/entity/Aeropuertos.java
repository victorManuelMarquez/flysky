package ar.com.codoacodo.flysky.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aeropuertos")
public class Aeropuertos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nombre;

    @Column
    private String ciudad;

    @OneToOne(mappedBy = "origen",cascade = CascadeType.ALL)
    @JsonIgnore
    private Vuelos vueloOrigen;

    @OneToOne(mappedBy = "destino",cascade = CascadeType.ALL)
    @JsonIgnore
    private Vuelos vueloDestino;

}
