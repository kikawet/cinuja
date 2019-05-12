/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author lopez
 */
@Path("/API")
@Produces(MediaType.APPLICATION_JSON)
public class GenericoRESTService {

    @Context
    private HttpServletRequest principal;

    @GET
    @Path("/sesion")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSesion() {
        return principal.getRemoteUser();
    }
}
