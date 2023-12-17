package ar.com.codoacodo.flysky.service;

import ar.com.codoacodo.flysky.exception.InformeNoEncontrado;
import ar.com.codoacodo.flysky.model.dto.DtoInforme;
import ar.com.codoacodo.flysky.model.dto.DtoPasajero;
import ar.com.codoacodo.flysky.model.dto.DtoVuelo;
import ar.com.codoacodo.flysky.model.entity.Informe;
import ar.com.codoacodo.flysky.model.entity.Pago;
import ar.com.codoacodo.flysky.model.entity.Pasajero;
import ar.com.codoacodo.flysky.model.entity.Vuelo;
import ar.com.codoacodo.flysky.repository.InformesRepository;
import ar.com.codoacodo.flysky.repository.PagosRepository;
import ar.com.codoacodo.flysky.repository.PasajerosRepository;
import ar.com.codoacodo.flysky.repository.VuelosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Service
@AllArgsConstructor
public class InformesServiceImpl implements  InformesService {
    @Autowired
    private PasajerosRepository pasajeroRepository;

    @Autowired
    private PagosRepository pagoRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private InformesRepository informeRepository;

    @Autowired
    private VuelosRepository vueloRepository;

    @Autowired
    private PasajerosService pasajeroService;

    @Override
    public List<DtoInforme> todosLosInformes() {
        informeRepository.deleteAll();

        // BUSCO PASAJEROS
        List<Pasajero> pasajeros = pasajeroRepository.findAll();

        for (Pasajero pasajero : pasajeros) {
            List<Pago> pagosDelPasajero = pagoRepository.findByPasajero(pasajero);

            String metodoPagoMasFrecuente = calcularMetodoPagoMasFrecuente(pagosDelPasajero);
            String asientoMasFrecuente = calcularAsientoMasFrecuente(pagosDelPasajero);
            String destinoMasFrecuente = calcularDestinoMasFrecuente(pagosDelPasajero);

            Informe informe = new Informe();
            informe.setPasajero(pasajero);
            informe.setPagos(pagosDelPasajero);
            informe.setPagop(metodoPagoMasFrecuente);
            informe.setAsientop(asientoMasFrecuente);
            informe.setDestinop(destinoMasFrecuente);

            informeRepository.save(informe);
        }
//ahgo un mapeo para que se muestre en json
        List<Informe> informes = informeRepository.findAll();

        return informes.stream()
                .map(informe -> {
                    DtoInforme dtoInforme = mapper.convertValue(informe, DtoInforme.class);
                    // obtengo el pasajero y asigno  al dto para mostralo
                    DtoPasajero dtoPasajero = pasajeroService.buscarPorId(informe.getPasajero().getId());
                    dtoInforme.setDtoPasajero(dtoPasajero);
                    return dtoInforme;
                })
                .collect(Collectors.toList());
    }


    private String calcularMetodoPagoMasFrecuente(List<Pago> pagos) {
                //                 return "metodoPago";

        Map<String, Integer> pagopreFrecuenteMap = new HashMap<>();
        // los recorro y controlo
        for (Pago pago : pagos) {
            String pagopre = pago.getMetodoPago().getNombre();
            pagopreFrecuenteMap.put(pagopre, pagopreFrecuenteMap.getOrDefault(pagopre, 0) + 1);
        }

        // inicializo para buscarlo
        String pagopreMasFrecuente = null;
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : pagopreFrecuenteMap.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                pagopreMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        return pagopreMasFrecuente;
            }


    private String calcularAsientoMasFrecuente(List<Pago> pagos) {
                //                return "asiento";
        Map<String, Integer> asientoFrecuenteMap = new HashMap<>();

        // los recorro y controlo
        for (Pago pago : pagos) {
           String clase = pago.getBoleto().getAeronave().getClase().getNombre();
            asientoFrecuenteMap.put(clase, asientoFrecuenteMap.getOrDefault(clase, 0) + 1);
        }

        // inicializo para buscarlo
        String asientpMasFrecuente = null;
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : asientoFrecuenteMap.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                asientpMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        return asientpMasFrecuente;
            }


    private String calcularDestinoMasFrecuente(List<Pago> pagos) {
//        return "destino";
        Map<String, Integer> destinoFrecuenteMap = new HashMap<>();


        // los recorro y controlo
        for (Pago pago : pagos) {
            //String destino = pago.getBoleto().getVuelo().getDestino().getNombre(); NOMBRE AEROPUERTO
            String destino = pago.getBoleto().getVuelo().getDestino().getCiudad();
            destinoFrecuenteMap.put(destino, destinoFrecuenteMap.getOrDefault(destino, 0) + 1);
        }

        // inicializo para buscarlo
        String destinoMasFrecuente = null;
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : destinoFrecuenteMap.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                destinoMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        return destinoMasFrecuente;

            }




    @Override
    public DtoInforme buscarPorId(Integer id) {
        Optional<Informe> informes = informeRepository.findById(id);
        if (informes.isPresent())
            return getMapper().convertValue(informes.get(), DtoInforme.class);
        else throw new InformeNoEncontrado();
    }

    @Override
    public DtoInforme agregarNuevo(DtoInforme nuevo) {
        Informe informe = informeRepository.save(getMapper().convertValue(nuevo, Informe.class));
        return getMapper().convertValue(informe, DtoInforme.class);
    }

    @Override
    public DtoInforme eliminar(Integer id) {
        return null;
    }
/*
    @Override
    public void calcularDestinoMasFrecuente() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        Map<String, Integer> destinoFrecuenteMap = new HashMap<>();

        // Recorre todos los vuelos y cuenta la frecuencia de cada destino
        for (Vuelo vuelo : vuelos) {
            String destino = vuelo.getDestino().getNombre(); // Ajusta según la estructura de tu entidad Aeropuerto
            destinoFrecuenteMap.put(destino, destinoFrecuenteMap.getOrDefault(destino, 0) + 1);
        }

        // Encuentra el destino más frecuente
        String destinoMasFrecuente = null;
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : destinoFrecuenteMap.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                destinoMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        // Actualiza el destino más frecuente en todos los informes
        List<Informe> informes = repository.findAll();
        for (Informe informe : informes) {
            informe.setDestinop(destinoMasFrecuente);
            repository.save(informe);
        }
    }
*/
    @Override
    public void calcularDestinoMasFrecuente() {
        List<Vuelo> vuelos = vueloRepository.findAll();
        Map<String, Integer> destinoFrecuenteMap = new HashMap<>();

        // Recorre todos los vuelos y cuenta la frecuencia de cada destino
        for (Vuelo vuelo : vuelos) {
            String destino = vuelo.getDestino().getNombre(); // Ajusta según la estructura de tu entidad Aeropuerto
            destinoFrecuenteMap.put(destino, destinoFrecuenteMap.getOrDefault(destino, 0) + 1);
        }

        // Encuentra el destino más frecuente
        String destinoMasFrecuente = null;
        int frecuenciaMaxima = 0;

        for (Map.Entry<String, Integer> entry : destinoFrecuenteMap.entrySet()) {
            if (entry.getValue() > frecuenciaMaxima) {
                destinoMasFrecuente = entry.getKey();
                frecuenciaMaxima = entry.getValue();
            }
        }

        // Persistir un nuevo Pasajero en la base de datos
        Pasajero nuevoPasajero = new Pasajero();
        // Configurar los valores del nuevo pasajero si es necesario
        pasajeroRepository.save(nuevoPasajero);

        // Actualiza el destino más frecuente en todos los informes y asigna el nuevo Pasajero
        List<Informe> informes = informeRepository.findAll();
        for (Informe informe : informes) {
            informe.setDestinop(destinoMasFrecuente);
            informe.setPasajero(nuevoPasajero);
            informeRepository.save(informe);
        }
        informeRepository.saveAll(informes);
        /*
            for (int i = 0; i < 5; i++) { // Agregar 5 informes como ejemplo
                Informe nuevoInforme = new Informe();
                nuevoInforme.setPasajero(new Pasajero()); // Debes asignar un Pasajero válido
                nuevoInforme.setAsientop("A" + (i + 1));
                nuevoInforme.setDestinop("Nuevo Aeropuerto Destino");
                nuevoInforme.setPagop("Tarjeta de Crédito");

                // Guardar el nuevo informe en la base de datos
                repository.save(nuevoInforme);}*/
        }
    }




