/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.util.Date;

/**
 * Para almacenar las preferencias y los datos de un usuario
 *
 * @author lopez
 */

public class Pelicula {

    private String nombre;
    private Date fecha;//estreno
    private String foto;//url
    private float nota;
    public String[] generos = {"", ""};
    private int genero;//indice
    private String descripcion;
    private boolean restriccionEdad;//restricción de edad
    private Director director;
}
