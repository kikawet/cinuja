/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.JDBC;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.qualifiers.DAOJDBC;
import java.sql.Connection;
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
public class ComentarioDAOJDBC implements ComentarioDAO {

    private Logger logger = Logger.getLogger(ComentarioDAOJDBC.class.getName());

    @Resource(lookup = "java:global/jdbc/Cinuja")
    private DataSource ds;

    public ComentarioDAOJDBC() {
    }

    private static Comentario comentarioMapper(ResultSet rs,Pelicula p){
        Comentario cm = new Comentario();
        cm.setPelicula(p);
//        cm.setUsuario(usuario);
        return cm;
    }
    
    @Override
    public List<Comentario> getComentarios(Pelicula p) {
        String query = "Select * from comentario as c , pelicula as p where c.pelicula = p.id AND p.url = " + p.getUrl();
        List<Comentario> comentarios = new ArrayList<>();
        try (
                Connection conn = ds.getConnection();
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ) {

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }

    @Override
    public boolean insertar(Comentario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrar(Comentario c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
