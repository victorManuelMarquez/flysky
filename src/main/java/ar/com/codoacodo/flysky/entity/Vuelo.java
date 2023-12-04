package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter


@Entity
@Table(name = "vuelos")
public class Vuelo {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 @ManyToOne
 @JoinColumn(name = "id_aerolinea", nullable = false)
 private Aerolinea aerolinea;

 @Column(name = "salida", nullable = false)
 private Date salida;

 @Column(name = "llegada", nullable = false)
 private Date llegada;

 @ManyToOne
 @JoinColumn(name = "id_origen", nullable = false)
 private Aeropuerto origen;

 @ManyToOne
 @JoinColumn(name = "id_destino", nullable = false)
 private Aeropuerto destino;


}
