/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author lopez
 */
@ApplicationScoped
public class Init /*implements Serializable*/ {

    @Inject
    @DAOList
    private PeliculaDAO peliculas;

    @Inject
    @DAOList
    private UsuarioDAO usuarios;

    @Inject
    @DAOList
    private ComentarioDAO comentarios;

//    public Init() {
//    }
    @PostConstruct
    public void init() {

        //Insertar películas -------------------------------------------------------------
        Pelicula p = new Pelicula();
        Director d = new Director();

        p.setFoto("http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg");
        p.setTitulo("Uno de los nuestros");
        p.setFecha(new Calendar.Builder().setDate(1990, 1, 1).build().getTime());
        p.setUrl("uno-de-los-nuestros");
        d.setNombre("Martin Scorsese");
        d.setFoto("http://d3iln1l77n73l7.cloudfront.net/couch_images/attachments/000/057/537/original/Martin_Scorsese.jpg?2014");
        p.setDirector(d);
        p.setDescripcion("Un hombre de Brooklyn busca la fama y la fortuna en el crimen organizado");
        p.setGenero(PeliculaDAO.generos.indexOf("Mafia"));
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg");
        p.setTitulo("Pulp Fiction");
        p.setFecha(new Calendar.Builder().setDate(1997, 1, 1).build().getTime());
        p.setUrl("pulp-fiction");
        d.setNombre("Quentin Tarantino");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Mafia"));
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg");
        p.setTitulo("Salvar al soldado Ryan");
        p.setFecha(new Calendar.Builder().setDate(1998, 1, 1).build().getTime());
        p.setUrl("salvar-al-soldado-bryan");
        d.setNombre("Steven Spielberg");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Bélico"));
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg");
        p.setTitulo("Ratatouille");
        p.setFecha(new Calendar.Builder().setDate(2007, 1, 1).build().getTime());
        p.setUrl("ratatouille");
        d.setNombre("Pixar");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Dibujos animados"));
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setFoto("https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg");
        p.setTitulo("Bohemian Rhapsody");
        p.setFecha(new Calendar.Builder().setDate(2018, 1, 1).build().getTime());
        p.setUrl("bohemian-rhapsody");
        d.setNombre("Bryan Singer");
        p.setDirector(d);
        p.setGenero(PeliculaDAO.generos.indexOf("Música"));
        peliculas.insertar(p);
        peliculas.insertar(p);
        peliculas.insertar(p);
        peliculas.insertar(p);

        //Insertar usuarios -----------------------------------------------------
        Usuario u = new Usuario();
        u.setNick("pescues");
        u.setNombre("flo");
        u.setFoto("https://cdn.discordapp.com/avatars/324587602042814464/63784f02344fafe52b780e5a0477c752.png?size=128");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("gordito");
        u.setFoto("https://ct.yimg.com/cy/1904/44016886825_e02d29_128sq.jpg");
        u.setNombre("José Tomas");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("boa");
        u.setFoto("https://66.media.tumblr.com/avatar_ea54a1bd0195_128.pnj");
        u.setNombre("Pescues");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("weeb");
        u.setFoto("http://pm1.narvii.com/6265/5bba4fd8638ebdea1100eb9b06940944a8913fc0_128.jpg");
        u.setNombre("Rodrigo");
        usuarios.insertar(u);

        //Insertar comentarios ---------------------------------------------------
        Comentario c = new Comentario();
        c.setPelicula(peliculas.getPeliculas().get(0));
        c.setUsuario(usuarios.getUsuario("gordito"));
        c.setFecha(new Date());
        c.setTitulo("Maravillosa");
        c.setTexto("La mejor pelicula de mi vida.");
        comentarios.insertar(c);

        c = new Comentario();
        c.setPelicula(peliculas.getPeliculas().get(0));
        c.setUsuario(usuarios.getUsuario("boa"));
        c.setFecha(new Date());
        c.setTitulo("No está mal");
        c.setTexto("Es bastante entretenida pero prefiero ver Salvame.");
        comentarios.insertar(c);

        c = new Comentario();
        c.setPelicula(peliculas.getPeliculas().get(0));
        c.setUsuario(usuarios.getUsuario("weeb"));
        c.setFecha(new Date());
        c.setTitulo("Aburrida");
        c.setTexto("Yo me aburrí. Preferiría morirme en este momento.");
        comentarios.insertar(c);

    }

}
