/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DTO;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
public class ComentarioDTO {

    @NotNull(message = "Todos los comentarios necesitan un titulo")
    @Size(min = 3, max = 20, message = "El titulo debe de tener un tamaño entre {min} y {max} caracteres")
    private String titulo;
    @NotNull(message = "El texto de un comentario es necesario")
    @Size(min = 3, max = 256, message = "El texto no tiene un tamaño entre {min} y {max} caracteres")
    private String texto;

   
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComentarioDTO other = (ComentarioDTO) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    public ComentarioDTO() {
        this.titulo = "";
        this.texto = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
