/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

import com.daw.cinuja.DAO.models.Usuario;

/**
 *
 * @author lopez
 */
public interface UsuarioDAO {

    public final static String QUALIFIER_ = "Usuario";

    public final static String ROL_ADMIN = "adm";

    public final static String ROL_NONE = "non";

    Usuario getUsuario(String nick);

    boolean insertar(Usuario u);

    boolean modificar(Usuario antiguo, Usuario nuevo);

    boolean borrar(Usuario u);
}
