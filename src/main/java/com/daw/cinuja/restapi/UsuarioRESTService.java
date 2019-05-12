/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Qualifier(DAOConfig.usuarioQualifier)
    UsuarioDAO usuarios;

    @GET
    @Path("/{nick}")
    public Response getUsuario(@PathParam("nick") String nick) {
        Usuario u = usuarios.getUsuario(nick);
        Response r;

        if (u != null) {
            r = Response.ok(u).build();
        } else {
            List<Map<String, Object>> errores = new ArrayList<>();
            Map<String, Object> err = new HashMap<>();
            err.put("message", "El usuario no existe");
            errores.add(err);
            r = Response.status(Response.Status.BAD_REQUEST)
                    .entity(errores).build();
        }
        return r;
    }

}
