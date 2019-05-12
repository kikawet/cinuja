/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

import com.daw.cinuja.DAO.JDBC.PeliculaDAOJDBC;

/**
 *
 * @author lopez
 */
public class DAOConfig {

    public final static String _DAOJDBC = "DAOJDBC";
    public final static String _DAOLIST = "DAOLIST";
    public final static String peliculaQualifier = PeliculaDAO.QUALIFIER_ + _DAOJDBC;
    public final static String usuarioQualifier = UsuarioDAO.QUALIFIER_ + _DAOJDBC;
    public final static String comentarioQualifier = ComentarioDAO.QUALIFIER_ + _DAOJDBC;
}
