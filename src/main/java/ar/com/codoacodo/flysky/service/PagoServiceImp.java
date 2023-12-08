package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.dto.PagoDto;
import ar.com.codoacodo.flysky.dto.response.RespuestaDto;
import ar.com.codoacodo.flysky.entity.Pago;
import ar.com.codoacodo.flysky.repository.IPagoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImp {

    private IPagoRepository repository;

    public PagoServiceImp(IPagoRepository repository) {        this.repository = repository;    }


    public RespuestaDto procesarPago(PagoDto pagoDto) {

        ObjectMapper mapper = new ObjectMapper();
        Pago pago = mapper.convertValue(pagoDto, Pago.class);

        pago = repository.save(pago);

        if (pago.getId() == null) {
            return new RespuestaDto("No sea ha realizar el pago por favor vuelva a intentarlo");
        }

        return new RespuestaDto("Reserva Pagada Correctamente");


    }



}
