/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author lopez
 */
@ApplicationScoped
public class UsuarioDAOList implements UsuarioDAO {

    private List<Usuario> usuarios;

    public UsuarioDAOList() {
        usuarios = new ArrayList<>();
    }

    @Override
    public Usuario getUsuario(String nick) {
        Usuario u = null;
        int i = 0;
        while (i < usuarios.size() && u == null) {
            if (usuarios.get(i).getNick() == nick) {
                u = usuarios.get(i);
            }
            i++;
        }
        return u;
    }

    @Override
    public boolean insertar(Usuario u) {
        return usuarios.add(u);
    }

    @Override
    public boolean borrar(Usuario u) {
        return usuarios.remove(u);
    }

}
