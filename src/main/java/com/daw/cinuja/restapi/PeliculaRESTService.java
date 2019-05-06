/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.JDBC.PeliculaDAOJDBC;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author axpos
 */

@Path("/pelicula")
@Produces(MediaType.APPLICATION_JSON)

public class PeliculaRESTService {
    
    @Context
    private UriInfo context;

    @Autowired     //Utilizamos anotaciones de inyección Spring
    @Qualifier(PeliculaDAOJDBC.qualifier)
    PeliculaDAO peliculas;
    
    @GET
    public String getstring(){
        
       return "Viva ortega cano"; 
        
    }
    
}
