/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Pelicula;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
//@ApplicationScoped
//@DAOList
@Repository(PeliculaDAOList.qualifier)
public class PeliculaDAOList implements PeliculaDAO {

    private List<Pelicula> peliculas;

    final static public String qualifier = "PeliculaDAOList";

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pelicula> getPeliculas(int genero) {

        List<Pelicula> pelis = new ArrayList<>(peliculas);

        for (int i = pelis.size() - 1; i >= 0; i--) {
            if (PeliculaDAO.generos.get(pelis.get(i).getGenero()).hashCode() != genero) {
                pelis.remove(i);
            }
        }

        return pelis;
    }

    @Override
    public boolean modificar(Pelicula antiguo, Pelicula nueva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
