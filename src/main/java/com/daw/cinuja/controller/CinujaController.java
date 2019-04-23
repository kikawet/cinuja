/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.controller;

import com.daw.cinuja.DAO.JDBC.*;
import com.daw.cinuja.DAO.interfaces.*;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Sesion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lopez
 */
@Controller
@RequestMapping("/portada")
public class CinujaController {

    @Autowired
    @Qualifier(PeliculaDAOJDBC.qualifier)
    private PeliculaDAO peliculas;

    @Autowired
    @Qualifier(UsuarioDAOJDBC.qualifier)
    private UsuarioDAO usuarios;

    @Autowired
    @Qualifier(ComentarioDAOJDBC.qualifier)
    private ComentarioDAO comentarios;

    @Autowired
    private Sesion sesion;

    @ModelAttribute("sesion")
    public Sesion getSesion() {
        return sesion;
    }

    @GetMapping("")
    public String visualizar(ModelMap model) {

        model.addAttribute("peliculas", peliculas.getPeliculas());
        model.addAttribute("generos", PeliculaDAO.generos);

        return "portada";
    }

    @GetMapping(value = "", params = "genero")
    public String visualizaGenero(@RequestParam(value = "genero", required = true) int genero, ModelMap model) {

        List<Pelicula> p = peliculas.getPeliculas(Utils.indiceGenero(genero));
        model.addAttribute("peliculas", p);
        model.addAttribute("generos", PeliculaDAO.generos);

        return "portada";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

}
