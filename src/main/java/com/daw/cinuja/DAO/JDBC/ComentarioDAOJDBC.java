/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DTO.ComentarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
//@RequestScoped
//@DAOJDBC
@Repository(ComentarioDAO.QUALIFIER_ + DAOConfig._DAOJDBC)
public class ComentarioDAOJDBC implements ComentarioDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

//    @Resource(lookup = "java:global/jdbc/Cinuja")
    @Autowired(required = false)
    private DataSource ds;

    @Autowired
    @Qualifier(DAOConfig.usuarioQualifier)
    private UsuarioDAO usuarios;

    @Autowired
    @Qualifier(DAOConfig.peliculaQualifier)
    private PeliculaDAO peliculas;

    public ComentarioDAOJDBC() {
    }

    @Override
    public List<Comentario> getComentarios(Pelicula p) {
        String query = "Select * from comentario as c , pelicula as p where c.pelicula = p.id AND p.url = '" + p.getUrl() + "'";
        List<Comentario> comentarios = new ArrayList<>();
        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            while (rs.next()) {
                comentarios.add(Utils.comentarioMapper(rs, p, usuarios.getUsuario(rs.getString("usuario"))));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }

    @Override
    public boolean insertar(Comentario c) {
        String query = "INSERT INTO COMENTARIO (PELICULA, USUARIO, FECHA, TITULO, TEXTO) VALUES (("
                + "SELECT id "
                + "FROM pelicula as p "
                + "WHERE p.url = '" + c.getPelicula().getUrl() + "'"
                + "),?,?,?,?)";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, c.getUsuario().getNick());
            st.setTimestamp(2, new java.sql.Timestamp(c.getFecha().getTime()));
            st.setString(3, c.getTitulo());
            st.setString(4, c.getTexto());

            res = st.execute();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public boolean borrar(Comentario c) {
        String query = "DELETE FROM comentario AS c WHERE c.usuario = ? AND c.pelicula = (SELECT id FROM pelicula WHERE pelicula.url = ?) AND c.fecha = ?";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, c.getUsuario().getNick());
            st.setString(2, c.getPelicula().getUrl());
            st.setTimestamp(3, new java.sql.Timestamp(c.getFecha().getTime()));

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public List<Comentario> getComentarios(Usuario u) {
        String query = "Select * "
                + "from comentario as c  "
                + "LEFT JOIN pelicula as p "
                + "on p.id = c.pelicula, "
                + "usuario as u "
                + "where c.usuario = u.nick AND u.nick = '" + u.getNick() + "'";

        List<Comentario> comentarios = new ArrayList<>();

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            Pelicula p;

            while (rs.next()) {
                p = peliculas.getPelicula(rs.getString(12));
                comentarios.add(Utils.comentarioMapper(rs, p, usuarios.getUsuario(rs.getString("usuario"))));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }

    @Override
    public boolean modificar(Comentario antiguo, Comentario nuevo) {
        String query = "UPDATE comentario SET titulo = ?, texto = ? "
                + " WHERE fecha = ? AND usuario = ? AND pelicula = (select id from pelicula where pelicula.url = ?)";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {

            st.setString(1, nuevo.getTitulo());
            st.setString(2, nuevo.getTexto());
            st.setTimestamp(3, new java.sql.Timestamp(antiguo.getFecha().getTime()));
            st.setString(4, antiguo.getUsuario().getNick());
            st.setString(5, antiguo.getPelicula().getUrl());

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

}
