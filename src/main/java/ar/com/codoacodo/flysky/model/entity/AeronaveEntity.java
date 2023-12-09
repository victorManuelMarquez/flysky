package ar.com.codoacodo.flysky.model.entity;

import ar.com.codoacodo.flysky.model.entity.keys.AeronaveKeys;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "aeronaves")
@IdClass(AeronaveKeys.class)
@SuppressWarnings("SpellCheckingInspection")
public class AeronaveEntity implements Serializable {

    /*@EmbeddedId
    private AeronaveKeys id;*/

    @Id
    @OneToOne
    @JoinColumn(name = "id_avion", nullable = false, insertable = false, updatable = false)
    private AvionEntity avion;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false, insertable = false, updatable = false)
    private AsientoEntity asiento;

    /*@Id
    private Integer id_avion;

    @Id
    private Integer id_asiento;

    @OneToOne
    @JoinColumn(name = "id_avion", foreignKey = @ForeignKey(name = "fk_aeronave_avion"))
    private AvionEntity avion;

    @ManyToOne
    @JoinColumn(name = "id_asiento", foreignKey = @ForeignKey(name = "fk_aeronave_asiento"))
    private AsientoEntity asiento;*/

}
