/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Para almacenar las preferencias y los datos de un usuario
 *
 * @author lopez
 */
public class Usuario {

    @NotNull
    @Size(min = 1, max = 20, message = "El nick de un usuario debe estar entre {min} y {max}")
    private String nick;
    @Size(min = 3, max = 20, message = "El nombre de un usuario debe estar entre {min} y {max}")
    private String nombre;
    @Size(min = 4, max = 20, message = "Los apellidos de un usuario debe estar entre {min} y {max}")
    private String apellidos;
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "La foto debe ser de una url")
    private String foto;//por ahora una url
    @Size(min = 6, message = "La contraseña debe de tener un minimo de {min} caracteres")
    private String contrasena;// solo se usa para registrar
    private String rol;//cambiar roles como los generos
    @Valid
    private Pelicula pFavorita;
    @Valid
    private Director dFavorito;

    public Usuario() {
        this.setNick("");
        this.setNombre("");
        this.setApellidos("");
        this.setFoto("");
    }

    public void copy(Usuario otro) {

        if (!this.equals(otro)) {
            this.setNick(otro.getNick());
            this.setNombre(otro.getNombre());
            this.setApellidos(otro.getApellidos());
            this.setFoto(otro.getFoto());
            this.setContrasena(otro.getContrasena());
            this.setRol(otro.getRol());
            this.setpFavorita(otro.getpFavorita());
            this.setdFavorito(otro.getdFavorito());
        }

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nick);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        return true;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Pelicula getpFavorita() {
        return pFavorita;
    }

    public void setpFavorita(Pelicula pFavorita) {
        this.pFavorita = pFavorita;
    }

    public Director getdFavorito() {
        return dFavorito;
    }

    public void setdFavorito(Director dFavorito) {
        this.dFavorito = dFavorito;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}
