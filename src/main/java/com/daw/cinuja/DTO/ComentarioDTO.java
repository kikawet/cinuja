/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DTO;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
public class ComentarioDTO {

    private int id;    //id de la base de datos
    @NotNull(message = "Todos los comentarios necesitan un titulo")
    @Size(min = 3, max = 20, message = "El titulo debe de tener un tamaño entre {min} y {max} caracteres")
    private String titulo;
    @NotNull(message = "El texto de un comentario es necesario")
    @Size(min = 3, max = 256, message = "El texto no tiene un tamaño entre {min} y {max} caracteres")
    private String texto;

    public ComentarioDTO() {
        this.id = 0;
        this.titulo = "";
        this.texto = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
