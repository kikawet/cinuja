/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

/**
 *
 * @author lopez
 */
@Configuration
public class Init /*implements Serializable*/ {

    @Autowired(required = false)
    @Qualifier(PeliculaDAO.QUALIFIER_ + DAOConfig._DAOLIST)
    private PeliculaDAO peliculas;

    @Autowired(required = false)
    @Qualifier(UsuarioDAO.QUALIFIER_ + DAOConfig._DAOLIST)
    private UsuarioDAO usuarios;

    @Autowired(required = false)
    @Qualifier(ComentarioDAO.QUALIFIER_ + DAOConfig._DAOLIST)
    private ComentarioDAO comentarios;

    public Init() {
    }

    @PostConstruct
    public void init() {
        //Insertar usuarios -----------------------------------------------------
        Usuario u = new Usuario();
        u.setNick("pescues");
        u.setNombre("flo");
        u.setContrasena("flo");
        u.setRol("adm");
        u.setFoto("https://cdn.discordapp.com/avatars/324587602042814464/63784f02344fafe52b780e5a0477c752.png?size=128");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("gordito");
        u.setContrasena("donuts");
        u.setNombre("José Tomas");
        u.setRol("non");
        u.setFoto("https://ct.yimg.com/cy/1904/44016886825_e02d29_128sq.jpg");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("boa");
        u.setContrasena("ponme_un_10_balsas");
        u.setNombre("Pescues");
        u.setRol("non");
        u.setFoto("https://66.media.tumblr.com/avatar_ea54a1bd0195_128.pnj");
        usuarios.insertar(u);

        u = new Usuario();
        u.setNick("web");
        u.setContrasena("daw");
        u.setNombre("Rodrigo");
        u.setRol("non");
        u.setFoto("http://pm1.narvii.com/6265/5bba4fd8638ebdea1100eb9b06940944a8913fc0_128.jpg");
        usuarios.insertar(u);

        //Insertar películas -------------------------------------------------------------
        Pelicula p = new Pelicula();
        Director d = new Director();

        p.setTitulo("Uno de los nuestros");
        p.setFecha(new Calendar.Builder().setDate(1990, 1, 1).build().getTime());
        p.setUrl("uno-de-los-nuestros");
        p.setDescripcion("Un hombre de Brooklyn busca la fama y la fortuna en el crimen organizado");
        p.setSumaVotos(47);
        p.setnVotos(10);
        p.setGenero(10);
        p.setFoto("http://es.web.img2.acsta.net/medias/nmedia/18/67/70/14/20077949.jpg");
        d.setNombre("Martin Scorsese");
        d.setFnacimiento(new Calendar.Builder().setDate(2018, 4, 2).build().getTime());
        d.setFoto("http://d3iln1l77n73l7.cloudfront.net/couch_images/attachments/000/057/537/original/Martin_Scorsese.jpg?2014");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Pulp Fiction");
        p.setFecha(new Calendar.Builder().setDate(1997, 1, 1).build().getTime());
        p.setUrl("pulp-fiction");
        p.setSumaVotos(46);
        p.setnVotos(10);
        p.setGenero(PeliculaDAO.generos.indexOf("Mafia"));
        p.setFoto("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2016/09/pulp-fiction_0.jpg");
        d.setNombre("Quentin Tarantino");
        d.setFnacimiento(new Calendar.Builder().setDate(2017, 2, 15).build().getTime());
        d.setFoto("https://www.cooperativa.cl/noticias/site/artic/20161104/imag/foto_0000000120161104090517.png");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Salvar al soldado Ryan");
        p.setFecha(new Calendar.Builder().setDate(1998, 1, 1).build().getTime());
        p.setUrl("salvar-al-soldado-bryan");
        p.setSumaVotos(0);
        p.setnVotos(1);
        p.setGenero(2);
        p.setFoto("https://twistedsifter.files.wordpress.com/2015/10/53-saving-private-ryan.jpg");
        d.setNombre("Steven Spielberg");
        d.setFnacimiento(new Calendar.Builder().setDate(2017, 2, 14).build().getTime());
        d.setFoto("https://media.metrolatam.com/2019/02/20/capturadepantalla20190219alas210214-35b457738219a1b024fbd90a66cb8914-600x400.jpg");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Ratatouille");
        p.setFecha(new Calendar.Builder().setDate(2007, 1, 1).build().getTime());
        p.setUrl("ratatouille");
        p.setSumaVotos(43);
        p.setnVotos(10);
        p.setGenero(6);
        p.setFoto("https://educayaprende.com/wp-content/uploads/2014/05/ratatouille-cover-caratula-dvd-disney-pixar.jpg");
        d.setNombre("Pixar");
        d.setFnacimiento(new Calendar.Builder().setDate(2000, 10, 6).build().getTime());
        d.setFoto("https://www.taquillaespana.es/wp-content/uploads/2018/06/Pixar-en-Espa%C3%B1a-740x445.jpg");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Bohemian Rhapsody");
        p.setFecha(new Calendar.Builder().setDate(2018, 1, 1).build().getTime());
        p.setUrl("bohemian-rhapsody");
        p.setSumaVotos(43);
        p.setnVotos(10);
        p.setGenero(11);
        p.setFoto("https://www.heraldo.es/ocio/sites/default/files/bohemian.jpg");
        d.setNombre("Bryan Singer");
        d.setFnacimiento(new Calendar.Builder().setDate(2000, 10, 16).build().getTime());
        d.setFoto("https://ichef.bbci.co.uk/news/660/cpsprodpb/1126/production/_105509340_hi051882259.jpg");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Batman: The Dark Knight");
        p.setFecha(new Calendar.Builder().setDate(2001, 10, 17).build().getTime());
        p.setUrl("batman");
        p.setSumaVotos(45);
        p.setnVotos(10);
        p.setGenero(0);
        p.setFoto("http://4.bp.blogspot.com/-nKSHSdwKeKc/UA2G4zIPHfI/AAAAAAAAOQI/8C-iUweMezE/s1600/elcaballerooscuroleyendarenace.jpg");
        d.setNombre("Christopher Nolan");
        d.setFnacimiento(new Calendar.Builder().setDate(2001, 10, 17).build().getTime());
        d.setFoto("https://pixel.nymag.com/imgs/daily/vulture/2018/09/11/15-Nolan.w330.h330.jpg");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("12 años de esclavitud");
        p.setFecha(new Calendar.Builder().setDate(1997, 2, 12).build().getTime());
        p.setUrl("doce-anos");
        p.setSumaVotos(44);
        p.setnVotos(10);
        p.setGenero(8);
        p.setFoto("https://images-na.ssl-images-amazon.com/images/I/61QFAKXbb5L._SY679_.jpg");
        d.setNombre("Steve McQueen");
        d.setFnacimiento(new Calendar.Builder().setDate(1997, 2, 12).build().getTime());
        d.setFoto("https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/Steve_McQueen.png/220px-Steve_McQueen.png");
        p.setDirector(d);
        peliculas.insertar(p);

        p = new Pelicula();
        d = new Director();
        p.setTitulo("Thor: Ragnarok");
        p.setFecha(new Calendar.Builder().setDate(2017, 8, 7).build().getTime());
        p.setUrl("thor");
        p.setSumaVotos(42);
        p.setnVotos(10);
        p.setGenero(0);
        p.setFoto("http://www.cineycine.com/archivos/2017/10/thor-ragnarok-poster.jpg");
        d.setNombre("Taika Waititi");
        d.setFnacimiento(new Calendar.Builder().setDate(2017, 8, 7).build().getTime());
        d.setFoto("https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Taika_Waititi_by_Gage_Skidmore.jpg/240px-Taika_Waititi_by_Gage_Skidmore.jpg");
        p.setDirector(d);
        peliculas.insertar(p);

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
        c.setUsuario(usuarios.getUsuario("web"));
        c.setFecha(new Date());
        c.setTitulo("Aburrida");
        c.setTexto("Yo me aburrí. Preferiría morirme en este momento.");
        comentarios.insertar(c);

    }
}
