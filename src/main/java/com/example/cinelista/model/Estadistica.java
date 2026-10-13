package com.example.cinelista.model;

/**
 * Representa una fila de la tabla de la seccion "Estadisticas"
 * (datos estaticos consumidos via GET /api/estadisticas por DataTables).
 *
 * De momento solo tiene "id" y "titulo", a juego con el resto del proyecto.
 *
 * TODO: anadid el resto de campos, con su getter y su setter:
 *  - genero         (String)
 *  - taquilla       (long)
 *  - nota           (int)
 */
public class Estadistica {

    private Long id;
    private String titulo;

    public Estadistica() {
    }

    public Estadistica(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
