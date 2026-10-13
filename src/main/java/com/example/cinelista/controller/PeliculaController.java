package com.example.cinelista.controller;

import com.example.cinelista.model.Pelicula;
import com.example.cinelista.repository.PeliculaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @GetMapping({"/", "/mi-lista"})
    public String miLista(Model model) {
        model.addAttribute("peliculas", peliculaRepository.obtenerTodas());
        return "mi-lista";
    }

    @GetMapping("/anadir-titulo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "anadir-titulo";
    }

    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaRepository.guardar(pelicula);
        return "redirect:/mi-lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id) {
        peliculaRepository.eliminarPorId(id);
        return "redirect:/mi-lista";
    }
}