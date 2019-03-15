/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

import com.daw.cinuja.DAO.models.Usuario;
import java.util.List;

/**
 *
 * @author lopez
 */
public interface UsuarioDAO {
    
    Usuario getUsuario(String nick);
    boolean insertar(Usuario u);
    boolean borrar(Usuario u);
    
}
