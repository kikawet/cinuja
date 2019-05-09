/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DTO;

import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
public class PeliculaDTO {

    @NotNull(message = "Todas las peliculas necesitan tener un titulo")
    @Size(min = 2, max = 30, message = "El titulo de una pelicula debe de tener entre {min} y {max} caracteres")
    private String titulo;
    @NotNull(message = "Se necesita que la pelicuta tenga la url con la que se mostrara en el navegador")
    @Pattern(regexp = "^[a-z]+(-[a-z]+)*", message = "La url no tiene el formato correcto (todo debe tener minusculas y separado por -)")
    private String url;
    //tambien puede ser una pelicula no estrenada
    //@Past(message = "La fecha en la que se estrenó la pelicula tiene que ser anterior a la actual")
    private String fecha;//estreno
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "La foto debe ser de una url")
    private String foto;//url 
    @Min(value = 0, message = "El genero debe de ser un indice de la lista de generos")
    //@Max(value = PeliculaDAO.generos.size())
    private int genero;//indice

    public PeliculaDTO() {
        this.titulo = "";
        this.url = "";
        this.fecha = "";
        this.foto = "";
        this.genero = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

}
