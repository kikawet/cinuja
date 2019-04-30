/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
//@RequestScoped
//@DAOJDBC
@Repository(UsuarioDAOJDBC.qualifier)
public class UsuarioDAOJDBC implements UsuarioDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    final static public String qualifier = "UsuarioDAOJDBC";

//    @Resource(lookup = "java:global/jdbc/Cinuja")
    @Autowired(required = false)
    private DataSource ds;

    public UsuarioDAOJDBC() {
    }

    @Override
    public Usuario getUsuario(String nick) {

        String query = "SELECT * "
                + "FROM USUARIO AS u "
                + "LEFT JOIN PELICULA AS p ON p.ID = u.PELICULA_FAV "
                + "LEFT JOIN DIRECTOR AS d ON d.ID = u.DIRECTOR_FAV "
                + "WHERE u.nick = '" + nick + "'";

        Usuario usuario = null;

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            if (rs.next()) {
                Director d = Utils.directorMapper(rs, 19);
                usuario = Utils.usuarioMapper(rs, 0, Utils.peliculaMapper(rs, 8, d), d);
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean insertar(Usuario u) {
        String query = "INSERT INTO usuario VALUES (?,?,?,?,?,?,(SELECT id FROM pelicula AS p WHERE p.url = ?),(SELECT id FROM director AS d WHERE d.nombre = ?))";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, u.getNick());
            st.setString(2, u.getNombre());
            st.setString(3, u.getApellidos());
            st.setString(4, u.getFoto());
            st.setString(5, u.getContrasena());
            st.setString(6, u.getRol());
            st.setString(7, u.getpFavorita().getUrl());
            st.setString(8, u.getdFavorito().getNombre());

            res = st.execute();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
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

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public boolean modificar(Usuario antiguo, Usuario nuevo) {
        String query = "UPDATE USUARIO SET NICK = ?, NOMBRE = ?, APELLIDOS = ?, FOTO = ?, CONTRASENA = ? WHERE NICK = ?";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, nuevo.getNick());
            st.setString(2, nuevo.getNombre());
            st.setString(3, nuevo.getApellidos());
            st.setString(4, nuevo.getFoto());
            st.setString(5, nuevo.getContrasena());
            st.setString(6, antiguo.getNick());

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

}
