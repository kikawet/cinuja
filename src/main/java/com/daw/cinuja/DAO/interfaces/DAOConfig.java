/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.interfaces;

/**
 * Configuración de las implementaciones de los DAOs y que tipo de daos se usan
 * en el proyecto
 *
 * @author lopez
 */
public class DAOConfig {

    public final static String _DAOJDBC = "DAOJDBC";
    public final static String _DAOLIST = "DAOLIST";

    //Nota: antes de usar DAOs de lista asegurate de activar la configuración en el fichero com.daw.cinuja.DAO.list.Init.java
    public final static String peliculaQualifier = PeliculaDAO.QUALIFIER_ + _DAOJDBC;
    public final static String usuarioQualifier = UsuarioDAO.QUALIFIER_ + _DAOJDBC;
    public final static String comentarioQualifier = ComentarioDAO.QUALIFIER_ + _DAOJDBC;
}
