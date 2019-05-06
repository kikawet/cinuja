/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.util.Date;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
public class Comentario {

    @NotNull(message = "Un comentario necesita un usuario")
    @Valid
    private Usuario usuario;
    @NotNull(message = "Un comentario necesita estar en una pelicula")
    @Valid
    private Pelicula pelicula;
    @NotNull(message = "Se necesita saber cuando se escribio el comentario")
    @Past(message = "La fecha en el comentario tiene que ser anterior a la actual")
    private Date fecha;
    @NotNull(message = "Todos los comentarios necesitan un titulo")
    @Size(min = 3, max = 20, message = "El titulo debe de tener un tamaño entre {min} y {max}")
    private String titulo;
    @NotNull(message = "El texto de un comentario es necesario")
    @Size(min = 3, max = 256, message = "El texto no tiene un tamaño entre {min} y {max}")
    private String texto;
    @DecimalMin(value = "0", inclusive = true, message = "La nota debe de ser mayor de {value}")
    @DecimalMax(value = "5", inclusive = true, message = "La nota debe ser menor de {value}")
    private float valoracion;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.usuario);
        hash = 67 * hash + Objects.hashCode(this.pelicula);
        hash = 67 * hash + Objects.hashCode(this.fecha);
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
        final Comentario other = (Comentario) obj;

        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this.pelicula, other.pelicula)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
