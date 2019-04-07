/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author lopez
 */
@ApplicationScoped
@DAOList
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

}
