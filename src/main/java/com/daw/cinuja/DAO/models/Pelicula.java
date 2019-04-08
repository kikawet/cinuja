/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Para almacenar las preferencias y los datos de un usuario
 *
 * @author lopez
 */
public class Pelicula {

    @NotNull(message = "Todas las peliculas necesitan tener un titulo")
    @Size(min = 2, max = 30, message = "El titulo de una pelicula debe de tener entre {min} y {max} caracteres")
    private String titulo;
    @NotNull(message = "Se necesita que la pelicuta tenga la url con la que se mostrara en el navegador")
    @Pattern(regexp = "^[a-z]+(-[a-z]+)*", message = "La url no tiene el formato correcto (todo debe tener minusculas y separado por -)")
    private String url;
    //tambien puede ser una pelicula no estrenada
    //@Past(message = "La fecha en la que se estrenó la pelicula tiene que ser anterior a la actual")
    private Date fecha;//estreno
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "La foto debe ser de una url")
    private String foto;//url 
    @DecimalMin(value = "0", inclusive = true, message = "La nota debe ser mayor de {value}")
    @DecimalMax(value = "5", inclusive = true, message = "La nota debe ser menor de {value}")
    private float nota;
    //@Size(min = 0/*,max = PeliculaDAO.generos.size()*/, message = "El genero debe de ser un indice de la lista de generos")
    @Min(value = 0, message = "El genero debe de ser un indice de la lista de generos")
    //@Max(value = PeliculaDAO.generos.size())
    private int genero;//indice
    @Size(min = 3, max = 256, message = "El tamaño de la descripción debe de estar entre {min} y {max}")
    private String descripcion;
    //debe de ser true si el genero es el de +18 pero no se poner esa restricción :/
    private boolean restriccionEdad;//restricción de edad
    @Valid
    private Director director;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.fecha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRestriccionEdad() {
        return restriccionEdad;
    }

    public void setRestriccionEdad(boolean restriccionEdad) {
        this.restriccionEdad = restriccionEdad;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
