/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.io.Serializable;
import java.util.Objects;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

enum Roles {
    user,
    admin
}

/**
 * Para almacenar las preferencias y los datos de un usuario
 *
 * @author lopez
 */
@Named(value = "perfil")
@SessionScoped
public class Usuario implements Serializable{

    private String nick;
    private String nombre;
    private String apellidos;
    private String foto;//por ahora una url
    private String contrasena;// no se usa
    private Roles rol;
    private Pelicula pFavorita;
    private Director dFavorito;
    
    public Usuario() {
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

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
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
