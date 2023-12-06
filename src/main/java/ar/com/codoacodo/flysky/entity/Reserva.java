package ar.com.codoacodo.flysky.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "reservas")
@IdClass(ReservaId.class)
public class Reserva {

    @Id
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "idVuelo", nullable = false)
    private Vuelo vuelo;

    @Id
    @ManyToOne
    @JoinColumn(name = "idPasajero", nullable = false)
    private Pasajero pasajero;

    @Column(name = "fechaReserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "comprobante", nullable = false)
    private String comprobante;

    @Column(name = "cancelada", nullable = false)
    private boolean cancelada;

}
