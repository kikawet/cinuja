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
import com.daw.cinuja.DTO.PeliculaDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    @Qualifier(DAOConfig.peliculaQualifier)
    private PeliculaDAO peliculas;

    @Autowired
    private Sesion sesion;

    @ModelAttribute("sesion")
    public Sesion getSesion() {
        return sesion;
    }

    @ModelAttribute
    private void processReques(ModelMap model) {
        if (this.sesion.getUsuario() != null && this.sesion.getUsuario().getRol().equals(UsuarioDAO.ROL_ADMIN)) {
            model.addAttribute("peliculaDTO", new PeliculaDTO());
            Map<Integer, String> generos = new HashMap<>();
            for (int i = 0; i < PeliculaDAO.generos.size(); i++) {
                generos.put(i, PeliculaDAO.generos.get(i));
            }
            model.addAttribute("mapGeneros", generos);
        }
        model.addAttribute("generos", PeliculaDAO.generos);

    }

    @GetMapping("")
    public String visualizar(ModelMap model) {
        model.addAttribute("peliculas", peliculas.getPeliculas());

        return "portada";
    }

    @GetMapping(value = "", params = "genero")
    public String visualizaGenero(@RequestParam(value = "genero", required = true) int genero, ModelMap model) {
        List<Pelicula> p = peliculas.getPeliculas(Utils.indiceGenero(genero));
        model.addAttribute("peliculas", p);

        return "portada";
    }
}
