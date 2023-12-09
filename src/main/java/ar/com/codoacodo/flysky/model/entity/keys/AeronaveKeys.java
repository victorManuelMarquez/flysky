package ar.com.codoacodo.flysky.model.entity.keys;

import ar.com.codoacodo.flysky.model.entity.AsientoEntity;
import ar.com.codoacodo.flysky.model.entity.AvionEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuppressWarnings("SpellCheckingInspection")
public class AeronaveKeys implements Serializable {

    @OneToOne
    @JoinColumn(name = "id_avion", nullable = false, insertable = false, updatable = false)
    private AvionEntity avion;

    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false, insertable = false, updatable = false)
    private AsientoEntity asiento;

}
