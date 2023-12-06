package ar.com.codoacodo.flysky.entity;

<<<<<<< HEAD

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

=======
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_reservas_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_vuelo", foreignKey = @ForeignKey(name = "fk_reservas_vuelo"))
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "id_pasajero", foreignKey = @ForeignKey(name = "fk_reservas_pasajero"))
    private Pasajero pasajero;

    private Date fechaReserva;

    //podria ser boolean
    private String comprobante;

    private byte cancelada;
>>>>>>> ee6658fe82dccc5cd3b2d6b7be61ca9d68e004a4
}
