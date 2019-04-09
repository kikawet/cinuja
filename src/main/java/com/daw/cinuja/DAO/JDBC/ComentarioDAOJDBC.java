/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DAO.qualifiers.DAOJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author lopez
 */
@RequestScoped
@DAOJDBC
public class ComentarioDAOJDBC implements ComentarioDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    @Resource(lookup = "java:global/jdbc/Cinuja")
    private DataSource ds;

    @Inject
    @DAOJDBC
    private UsuarioDAO usuarios;

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
                comentarios.add(Mapper.comentarioMapper(rs, p, usuarios.getUsuario(rs.getString("usuario"))));
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
                + "WHERE p.nombre = '" + c.getPelicula().getTitulo() + "'"
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
        String query = "DELETE FROM comentario AS c WHERE c.usuario = ? AND c.pelicula = (SELECT id FROM pelicula WHERE pelicula.nombre = ?)";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, c.getUsuario().getNick());
            st.setString(2, c.getPelicula().getTitulo());

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

}
