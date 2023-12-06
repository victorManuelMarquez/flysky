package ar.com.codoacodo.flysky.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
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
 @JoinColumn(name = "idAerolinea", nullable = false)
 private Aerolinea aerolinea;

 @Column(name = "salida", nullable = false)
 private Date salida;

 @Column(name = "llegada", nullable = false)
 private Date llegada;

 @ManyToOne
 @JoinColumn(name = "idOrigen", nullable = false)
 private Aeropuerto origen;

 @ManyToOne
 @JoinColumn(name = "idDestino", nullable = false)
 private Aeropuerto destino;

=======
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "vuelos")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", foreignKey = @ForeignKey(name = "fk_vuelos_aerolinea"))
    private Aerolinea aerolinea;
    private Date salida;
    private Date llegada;

    @ManyToOne
    @JoinColumn(name = "id_origen", foreignKey = @ForeignKey(name = "fk_vuelos_origen"))
    private Aeropuerto origen;

    @ManyToOne
    @JoinColumn(name = "id_destino", foreignKey = @ForeignKey(name = "fk_vuelos_destino"))
    private Aeropuerto destino;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
