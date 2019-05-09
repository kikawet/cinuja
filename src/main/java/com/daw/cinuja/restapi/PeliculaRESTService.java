/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.JDBC.PeliculaDAOJDBC;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Pelicula;
import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public List<Pelicula> getPeliculas() {
        return peliculas.getPeliculas();
    }

    @GET
    @Path("/gen/{gen}")
    public List<Pelicula> getGenero(@PathParam("gen") int genero) {
        return peliculas.getPeliculas(genero);
    }

    @GET
    @Path("/url/{url}")
    public Pelicula getPelicula(@PathParam("url") String url) {
        return peliculas.getPelicula(url);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevaPelicula(@Valid Pelicula p) {
        return Response.ok(p).build();
    }
}
