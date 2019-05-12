/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
public class UsuarioDTO {

    @NotNull
    @Size(min = 1, max = 20, message = "El nick de un usuario debe estar entre {min} y {max}")
    @Pattern(regexp = "^(\\S+)$", message = "El nick no puede contener espacios en blanco")
    private String nick;
    @Size(min = 3, max = 20, message = "El nombre de un usuario debe estar entre {min} y {max}")
    private String nombre;
    @Size(min = 4, max = 20, message = "Los apellidos de un usuario debe estar entre {min} y {max}")
    private String apellidos;
    @Size(min = 6, message = "La contraseña debe de tener un minimo de {min} caracteres")
    private String contrasena;// solo se usa para registrar
    private boolean terminos;

    public UsuarioDTO() {
        this.nick = "";
        this.nombre = "";
        this.apellidos = "";
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }

}
