/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author lopez
 */
@ApplicationScoped
@DAOList
public class ComentarioDAOList implements ComentarioDAO{

    private MultivaluedMap<Pelicula,Comentario> comentarios;
    
    public ComentarioDAOList() {     
        comentarios = new MultivaluedHashMap<>();
    }
    
    @Override
    public List<Comentario> getComentarios(Pelicula p) {
        return comentarios.get(p);
    }

    @Override
    public boolean insertar(Comentario c) {
        comentarios.add(c.getPelicula(), c);
        return comentarios.get(c.getPelicula()).contains(c);
    }

    @Override
    public boolean borrar(Comentario c) {
        return comentarios.remove(c.getPelicula(), c);
    }
    
}
