/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DAO.models.Usuario;
import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

/**
 *
 * @author lopez
 */
@Path("/API")
@Produces(MediaType.APPLICATION_JSON)
//@RequestScope
public class GenericoRESTService {

    @Context
    private HttpServletRequest principal;

//    @Autowired
//    private Sesion sesion;
    @GET
    @Path("/sesion")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSesion() {
        return principal.getRemoteUser();
    }
}
