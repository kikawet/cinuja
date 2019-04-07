/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DAO.qualifiers.DAOJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;

/**
 *
 * @author lopez
 */
@RequestScoped
@DAOJDBC
public class UsuarioDAOJDBC implements UsuarioDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    @Resource(lookup = "java:global/jdbc/Cinuja")
    private DataSource ds;

    public UsuarioDAOJDBC() {
    }

    @Override
    public Usuario getUsuario(String nick) {

        String query = "SELECT * "
                + "FROM USUARIO AS u "
                + "LEFT JOIN PELICULA AS p ON p.ID = u.PELICULA_FAV "
                + "LEFT JOIN DIRECTOR AS d ON d.ID = u.DIRECTOR_FAV "
                + "WHERE u.nick = '" + nick+"'";

        Usuario usuario = null;

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            rs.next();

            Director d = Mapper.directorMapper(rs, 18);

            usuario = Mapper.usuarioMapper(rs, 0, Mapper.peliculaMapper(rs, 8, d), d);

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean insertar(Usuario u) {
        String query = "INSERT INTO usuario VALUES (?,?,?,?,?,?,(SELECT id FROM pelicula AS p WHERE p.nombre = ?),(SELECT id FROM director AS d WHERE d.nombre = ?))";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, u.getNick());
            st.setString(2,u.getNombre());
            st.setString(3, u.getApellidos());
            st.setString(4, u.getFoto());
            st.setString(5, u.getContrasena());
            st.setString(6, u.getRol());
            st.setString(7, u.getpFavorita().getTitulo());
            st.setString(8, u.getdFavorito().getNombre());

            res = st.execute();
        } catch (Exception e) {
        }

        return res;
    }

    @Override
    public boolean borrar(Usuario u) {
        String query = "DELETE FROM usuario AS u WHERE u.nick = ?";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, u.getNick());

            res = st.execute();

        } catch (Exception e) {
        }

        return res;
    }

}
