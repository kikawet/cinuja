/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Pelicula;
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
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
//@RequestScoped
//@DAOJDBC
@Repository(PeliculaDAOJDBC.qualifier)
public class PeliculaDAOJDBC implements PeliculaDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    final static public String qualifier = "PeliculaDAOJDBC";

//    @Resource(lookup = "java:global/jdbc/Cinuja")
    @Autowired(required = false)
    private DataSource ds;

    public PeliculaDAOJDBC() {
    }

    @Override
    public List<Pelicula> getPeliculas() {
        String query = "SELECT * "
                + "FROM PELICULA as p "
                + "LEFT JOIN director as d "
                + "ON p.DIRECTOR = d.ID";
        List<Pelicula> peliculas = new ArrayList<>();

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            while (rs.next()) {
                peliculas.add(Utils.peliculaMapper(rs, 0, Utils.directorMapper(rs, 11)));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return peliculas;
    }

    @Override
    public boolean insertar(Pelicula p) {
        String query = "INSERT INTO PELICULA (nombre,fecha,foto,url,sumaVotos,nVotos,genero,DESCRIPCION,RESTRICCION,director) VALUES (?,?,?,?,?,?,?,?,(SELECT id FROM director AS d WHERE d.nombre = ?))";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, p.getTitulo());
            st.setDate(2, new java.sql.Date(p.getFecha().getTime()));
            st.setString(3, p.getFoto());
            st.setString(4, p.getUrl());
            st.setLong(5, p.getSumaVotos());
            st.setLong(6, p.getnVotos());
            st.setInt(7, p.getGenero());
            st.setBoolean(8, p.isRestriccionEdad());
            st.setString(9, p.getDirector().getNombre());

            res = st.execute();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public boolean borrar(Pelicula p) {
        String query = "DELETE FROM pelicula AS p WHERE p.nombre = ?";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, p.getTitulo());

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

    @Override
    public Pelicula getPelicula(String url) {
        String query = "SELECT * "
                + "FROM PELICULA AS p "
                + "LEFT JOIN DIRECTOR AS d "
                + "ON p.DIRECTOR = d.ID "
                + "WHERE URL = '" + url + "'";

        Pelicula pelicula = null;

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            if (rs.next()) {
                pelicula = Utils.peliculaMapper(rs, 0, Utils.directorMapper(rs, 11));
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return pelicula;
    }

    @Override
    public List<Pelicula> getPeliculas(int genero) {
        String query = "SELECT * "
                + "FROM PELICULA as p "
                + "LEFT JOIN director as d "
                + "ON p.DIRECTOR = d.ID "
                + "WHERE GENERO = " + genero;
        List<Pelicula> peliculas = new ArrayList<>();

        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);) {

            while (rs.next()) {
                peliculas.add(Utils.peliculaMapper(rs, 0, Utils.directorMapper(rs, 11)));
            }

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return peliculas;
    }

    @Override
    public boolean modificar(Pelicula antigua, Pelicula nueva) {
        String query = "UPDATE PELICULA SET NOMBRE = ?, FECHA = ?, FOTO = ?, URL = ?, sumaVotos = ?, nVotos = ? ,GENERO = ?, DESCRIPCION = ?, RESTRICCION = ? WHERE URL = ?";

        boolean res = false;
        try (
                Connection conn = ds.getConnection();
                PreparedStatement st = conn.prepareStatement(query);) {
            st.setString(1, nueva.getTitulo());
            st.setDate(2, new java.sql.Date(nueva.getFecha().getTime()));
            st.setString(3, nueva.getFoto());
            st.setString(4, nueva.getUrl());
            st.setLong(5, nueva.getSumaVotos());
            st.setLong(6, nueva.getnVotos());
            st.setInt(7, nueva.getGenero());
            st.setString(8, nueva.getDescripcion());
            st.setBoolean(9, nueva.isRestriccionEdad());
            st.setString(10, antigua.getUrl());

            res = st.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }

        return res;
    }

}
