/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
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
@Repository(UsuarioDAO.QUALIFIER_ + DAOConfig._DAOJDBC)
public class UsuarioDAOJDBC implements UsuarioDAO {

    private static final Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    @Autowired(required = false)
    private DataSource ds;

    public UsuarioDAOJDBC() {
    }

    @Override
    public Usuario getUsuario(String nick) {
        final String query = "SELECT * "
                + "FROM USUARIO AS u "
                + "WHERE u.nick = '" + nick + "'";

        Usuario usuario = null;

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            if (rs.next()) {
                usuario = Utils.usuarioMapper(rs, 0);
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    @Override
    public boolean insertar(Usuario u) {
        String query = "INSERT INTO usuario VALUES (?,?,?,?,?,?)";

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
