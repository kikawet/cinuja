/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DTO.ComentarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lopez
 */
//@ApplicationScoped
//@DAOList
@Repository(ComentarioDAO.QUALIFIER_ + DAOConfig._DAOLIST)
public class ComentarioDAOList implements ComentarioDAO {

    private MultivaluedMap<Pelicula, Comentario> comentarios;

    public ComentarioDAOList() {
        comentarios = new MultivaluedHashMap<>();
        //post construct en 2 a
    }

    @Override
    public List<Comentario> getComentarios(Pelicula p) {
        return comentarios.get(p);
    }

    @Override
    public boolean insertar(Comentario c) {
//        if (comentarios.isEmpty() || comentarios.get(c.getPelicula()).isEmpty() || !comentarios.get(c.getPelicula()).contains(c)) {
        comentarios.add(c.getPelicula(), c);
//        }
        return comentarios.get(c.getPelicula()).contains(c);
    }

    @Override
    public boolean borrar(Comentario c) {
        return comentarios.remove(c.getPelicula(), c);
    }

    @Override
    public List<Comentario> getComentarios(Usuario u) {
        List<Comentario> c = new ArrayList<>();
        for (List<Comentario> value : comentarios.values()) {
            for (Comentario comentario : value) {
                if (comentario.getUsuario().equals(u)) {
                    c.add(comentario);
                }
            }
        }

        return c;
    }

    @Override
    public boolean modificar(Comentario antiguo, Comentario nuevo) {
        int pos = comentarios.get(antiguo.getPelicula()).indexOf(antiguo);
        if (pos != -1) {
            Comentario c = comentarios.get(antiguo.getPelicula()).get(pos);
            c.setTitulo(nuevo.getTitulo());
            c.setTexto(nuevo.getTexto());
        }
        return pos != -1;
    }

}
