/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

import com.daw.cinuja.DAO.models.Pelicula;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lopez
 */
public interface PeliculaDAO {

    /**
     * generos posibles de las peliculas
     */
    public static final List<String> generos = new ArrayList<>(Arrays.asList("Acción y aventura", "Adultos (+18)", "Bélico", "Ciencia ficción", "Comedia", "Deportes", "Dibujos animados", "Documentales",
            "Drama", "Familiar", "Mafia", "Música", "Romántica", "Terror", "Thriller"));

    List<Pelicula> getPeliculas();

    List<Pelicula> getPeliculas(int genero);

    Pelicula getPelicula(String url);

    boolean insertar(Pelicula p);

    boolean borrar(Pelicula p);

    boolean modificar(Pelicula antiguo, Pelicula nueva);
}
