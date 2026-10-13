package com.example.cinelista.model;

/**
 * Representa un proximo estreno mostrado en la seccion de solo lectura
 * "Estrenos" (componente React TarjetaEstreno).
 *
 * De momento solo tiene "titulo", a juego con el resto del proyecto.
 *
 * TODO: anadid el resto de campos, con su getter y su setter:
 *  - fechaEstreno (String)
 *  - genero       (String)
 *  - plataforma   (String)
 */
public class Estreno {

    private Long id;
    private String titulo;

    public Estreno() {
    }

    public Estreno(Long id, String titulo) {
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