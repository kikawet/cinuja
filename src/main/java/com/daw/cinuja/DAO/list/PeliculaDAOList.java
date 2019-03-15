/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author lopez
 */
@ApplicationScoped
public class PeliculaDAOList implements PeliculaDAO {

    private List<Pelicula> peliculas;

    public PeliculaDAOList() {

        peliculas = new ArrayList<>();
        Pelicula p = new Pelicula();
        Director d = new Director();
        //añado las películas
        p.setFoto("http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg");
        p.setTitulo("Uno de los nuestros");
        p.setFecha(new Date(1990, 1, 1));
        d.setNombre("Martin Scorsese");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Mafia"));
        peliculas.add(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg");
        p.setTitulo("Pulp Fiction");
        p.setFecha(new Date(1997, 1, 1));
        d.setNombre("Quentin Tarantino");
        p.setDirector(d);
        peliculas.add(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg");
        p.setTitulo("Salvar al soldado Bryan");
        p.setFecha(new Date(1998, 1, 1));
        d.setNombre("Steven Spielberg");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Bélico"));
        peliculas.add(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg");
        p.setTitulo("Ratatouille");
        p.setFecha(new Date(2007, 1, 1));
        d.setNombre("Pixar");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Dibujos animados"));
        peliculas.add(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg");
        p.setTitulo("Bohemian Rhapsody");
        p.setFecha(new Date(2018, 1, 1));
        d.setNombre("Bryan Singer");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Música"));
        peliculas.add(p);
        peliculas.add(p);
        peliculas.add(p);
        peliculas.add(p);
    }

    @Override
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @Override
    public boolean insertar(Pelicula p) {
        return peliculas.add(p);
    }

    @Override
    public boolean borrar(Pelicula p) {
        return peliculas.remove(p);
    }

}
