package ar.com.codoacodo.flysky.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuppressWarnings("SpellCheckingInspection")
public class Informe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInforme;

    @ManyToOne
    @JoinColumn(name = "id_pasajero")
    private Pasajero pasajero;

    @OneToMany(mappedBy = "informe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pago> pagos;

    @Column
    private String asientop;

    @Column
    private String destinop;

    @Column
    private String pagop;
/*
    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }*/
}