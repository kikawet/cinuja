/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import java.util.List;

/**
 *
 * @author lopez
 */
public interface ComentarioDAO {

    List<Comentario> getComentarios(Pelicula p);

    List<Comentario> getComentarios(Usuario u);

    boolean insertar(Comentario c);

    boolean borrar(Comentario c);
}
