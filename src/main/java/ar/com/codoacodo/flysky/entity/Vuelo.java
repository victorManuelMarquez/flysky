package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String aerolinea;
    private Long precio;
    private Date salida;
    private String origen;
    private Date llegada;
    private String destino;
}
