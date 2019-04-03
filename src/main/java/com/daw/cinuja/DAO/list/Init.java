/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.list;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author lopez
 */
@ApplicationScoped
public class Init {
    
    @Inject
    private PeliculaDAO p;
    
    @Inject
    private UsuarioDAO u;
    
    @Inject
    @DAOList
    private ComentarioDAO c;
    
    @PostConstruct
    private void init(){
        //crear los comentarios
    }
    
}
