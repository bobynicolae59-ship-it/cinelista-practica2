package com.example.cinelista.repository;

import com.example.cinelista.model.Pelicula;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PeliculaRepository {

    private final List<Pelicula> peliculas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PeliculaRepository() {
        // Datos iniciales de la tabla requerida
        guardar(new Pelicula(null, "Interstellar", "Ciencia Ficcion", "Hbo Max", "Vista", "5 estrellas"));
        guardar(new Pelicula(null, "Breaking Bad", "Drama", "Netflix", "No vista", "-"));
    }

    public List<Pelicula> obtenerTodas() {
        return new ArrayList<>(peliculas);
    }

    public void guardar(Pelicula pelicula) {
        if (pelicula.getId() == null) {
            pelicula.setId(idGenerator.getAndIncrement());
        }
        peliculas.add(pelicula);
    }

    public void eliminarPorId(Long id) {
        peliculas.removeIf(p -> p.getId() != null && p.getId().equals(id));
    }
}