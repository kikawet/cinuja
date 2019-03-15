/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

enum Roles{    
    user,
    admin
}
        

/**
 * Para almacenar las preferencias y los datos de un usuario
 * @author lopez
 */
public class Usuario {
    private String nick;
    private String nombre;
    private String apellidos;
    private String foto;//por ahora una url
    //String contrasena;// no se usa
    private Roles rol;
    private Pelicula favorita;
    private Director favorito;
}
