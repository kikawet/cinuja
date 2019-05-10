/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.io.Serializable;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 *
 * @author lopez
 */
//@Named(value = "sesion")
@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Sesion implements Serializable {

    //@Valid
    private Usuario usuario;

    public Sesion() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
