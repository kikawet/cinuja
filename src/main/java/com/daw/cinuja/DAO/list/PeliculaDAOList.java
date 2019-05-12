/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Pelicula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
@Repository(PeliculaDAO.QUALIFIER_ + DAOConfig._DAOLIST)
public class PeliculaDAOList implements PeliculaDAO {

    private List<Pelicula> peliculas;

    public PeliculaDAOList() {

        peliculas = new ArrayList<>();
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public boolean insertar(Pelicula p) {
        return (!peliculas.contains(p)) ? (peliculas.add(p)) : (false);
    }

    @Override
    public boolean borrar(Pelicula p) {
        return peliculas.remove(p);
    }

    @Override
    public Pelicula getPelicula(String url) {
        int i = 0;

        while (i < peliculas.size() && !peliculas.get(i).getUrl().equals(url)) {
            i++;
        }

        return peliculas.get(i);
    }

    @Override
    public List<Pelicula> getPeliculas(int genero) {

        List<Pelicula> pelis = new ArrayList<>();

        for (Pelicula pelicula : peliculas) {
            if (pelicula.getGenero() == genero) {
                pelis.add(pelicula);
            }
        }

        return pelis;
    }

    @Override
    public boolean modificar(Pelicula antiguo, Pelicula nueva) {
        int pos = peliculas.indexOf(antiguo);

        if (pos != -1) {
            peliculas.set(pos, nueva);
        }

        return pos != -1;
    }

}
