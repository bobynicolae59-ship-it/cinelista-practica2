package com.example.cinelista.controller;

import com.example.cinelista.model.Estadistica;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Seccion "Estadisticas".
 *
 * Aqui solo se resuelve la ruta de la pagina (/estadisticas). A diferencia
 * de "Estrenos", aqui teneis que anadir vosotros el controlador REST
 * GET /api/estadisticas devolviendo datos estatico: ese endpoint NO esta
 * implementado todavia.
 *
 * TODO: cuando el modelo Estadistica tenga mas campos,
 * actualizad tambien esta lista estatica con esos datos.
 */
@Controller
public class EstadisticasController {

    private static final List<Estadistica> ESTADISTICAS = List.of(
            new Estadistica(1L, "Nebula Roja"),
            new Estadistica(2L, "El Ultimo Faro"),
            new Estadistica(3L, "Codigo Fantasma"),
            new Estadistica(4L, "Risas de Medianoche"),
            new Estadistica(5L, "Fuego Cruzado")
    );

    @GetMapping("/estadisticas")
    public String estadisticas() {
        return "estadisticas";
    }

    // TODO:
    // @GetMapping("/api/estadisticas")
    // @ResponseBody
    // public List<?> apiEstadisticas() { ... }
}