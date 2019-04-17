/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Director;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lopez
 */
public class Utils {

    public static int indiceGenero(int hashGenero) {
        int i = 0;
        boolean encontrado = false;

        while (!encontrado && i < PeliculaDAO.generos.size()) {
            encontrado = PeliculaDAO.generos.get(i).hashCode() == hashGenero;
            i++;
        }

        return (encontrado) ? (i - 1) : (-1);
    }

    public static Comentario comentarioMapper(ResultSet rs, Pelicula p, Usuario u) throws SQLException {
        Comentario cm = new Comentario();
        cm.setFecha(rs.getDate("fecha"));
        cm.setTitulo(rs.getString("titulo"));
        cm.setTexto(rs.getString("texto"));
        cm.setValoracion(rs.getFloat("valoracion"));
        cm.setUsuario(u);
        cm.setPelicula(p);
        return cm;
    }

    public static Pelicula peliculaMapper(ResultSet rs, int offset, Director d) throws SQLException {
        Pelicula p = new Pelicula();

        p.setTitulo(rs.getString(offset + 2));
        p.setFecha(rs.getDate(offset + 3));
        p.setFoto(rs.getString(offset + 4));
        p.setUrl(rs.getString(offset + 5));
//        p.setNota(rs.getFloat(offset + 6));
        p.setGenero(rs.getInt(offset + 7));
        p.setDescripcion(rs.getString(offset + 8));
        p.setRestriccionEdad(rs.getBoolean(offset + 9));
        p.setDirector(d);

        return p;
    }

    public static Director directorMapper(ResultSet rs, int offset) throws SQLException {
        Director d = new Director();

        d.setNombre(rs.getString(offset + 2));
        d.setFnacimiento(rs.getDate(offset + 3));
        d.setFoto(rs.getString(offset + 4));
        d.setApellidos(rs.getString(offset + 5));
        d.setBiografia(rs.getString(offset + 6));

        return d;
    }

    public static Usuario usuarioMapper(ResultSet rs, int offset, Pelicula p, Director d) throws SQLException {
        Usuario u = new Usuario();

        u.setNick(rs.getString(offset + 1));
        u.setNombre(rs.getString(offset + 2));
        u.setApellidos(rs.getString(offset + 3));
        u.setFoto(rs.getString(offset + 4));
        //5 contraseña
        u.setRol(rs.getString(offset + 6));
        u.setpFavorita(p);
        u.setdFavorito(d);

        return u;
    }

}
