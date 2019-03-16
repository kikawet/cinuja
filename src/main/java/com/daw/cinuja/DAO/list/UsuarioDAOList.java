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

        Usuario u = new Usuario();
        u.setNick("gordito");
        u.setFoto("https://ct.yimg.com/cy/1904/44016886825_e02d29_128sq.jpg");
        u.setNombre("José Tomas");
        usuarios.add(u);

        u = new Usuario();
        u.setNick("boa");
        u.setFoto("https://66.media.tumblr.com/avatar_ea54a1bd0195_128.pnj");
        u.setNombre("Pescues");
        usuarios.add(u);

        u = new Usuario();
        u.setNick("weeb");
        u.setFoto("http://pm1.narvii.com/6265/5bba4fd8638ebdea1100eb9b06940944a8913fc0_128.jpg");
        u.setNombre("Rodrigo");
        usuarios.add(u);
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
