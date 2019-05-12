/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.models.Pelicula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author axpos
 */
@Path("/pelicula")
@Produces(MediaType.APPLICATION_JSON)

public class PeliculaRESTService {

    @Autowired     //Utilizamos anotaciones de inyección Spring
    @Qualifier(DAOConfig.peliculaQualifier)
    PeliculaDAO peliculas;

    @GET
    public List<Pelicula> getPeliculas() {
        return peliculas.getPeliculas();
    }

    @GET
    @Path("/generos")
    public List<String> getGeneros() {
        return PeliculaDAO.generos;
    }

    @GET
    @Path("/gen/{gen}")
    public List<Pelicula> getGenero(@PathParam("gen") int genero) {
        return peliculas.getPeliculas(genero);
    }

    @GET
    @Path("/url/{url}")
    public Response getPelicula(@PathParam("url") String url) {
        Pelicula p = peliculas.getPelicula(url);
        Response r;

        if (p != null) {
            r = Response.ok(p).build();
        } else {
            List<Map<String, Object>> errores = new ArrayList<>();
            Map<String, Object> err = new HashMap<>();
            err.put("message", "La pelicula no existe");
            errores.add(err);
            r = Response.status(Response.Status.BAD_REQUEST)
                    .entity(errores).build();
        }
        return r;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevaPelicula(@Valid Pelicula p) {
        return Response.ok(p).build();
    }
}
