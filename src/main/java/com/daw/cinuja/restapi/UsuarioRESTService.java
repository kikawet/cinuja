/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.JDBC.UsuarioDAOJDBC;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Usuario;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author lopez
 */
@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioRESTService {

    @Context
    private UriInfo context;

    @Autowired     //Utilizamos anotaciones de inyección Spring
    @Qualifier(UsuarioDAOJDBC.qualifier)
    UsuarioDAO usuarios;

    @GET
    @Path("/{nick}")
    public Usuario getUsuario(@PathParam("nick") String nick) {
        return usuarios.getUsuario(nick);
    }

}
