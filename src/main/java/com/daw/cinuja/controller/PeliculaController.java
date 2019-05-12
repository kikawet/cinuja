/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.controller;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.DAOConfig;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DTO.ComentarioDTO;
import com.daw.cinuja.DTO.PeliculaDTO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lopez
 */
@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    @Qualifier(DAOConfig.peliculaQualifier)
    private PeliculaDAO peliculas;

    @Autowired
    @Qualifier(DAOConfig.comentarioQualifier)
    private ComentarioDAO comentarios;

    @Autowired
    private Sesion sesion;

    public PeliculaController() {
    }

    @ModelAttribute("sesion")
    public Sesion getSesion() {
        return sesion;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @ModelAttribute
    protected void processRequest(@PathVariable(required = false) String url_peli, HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
    }

    @GetMapping("/{url_peli}")
    public String visualiza(ModelMap model, @PathVariable String url_peli) {
        if (sesion.getUsuario() != null) {
            model.addAttribute("comentarioDTO", new ComentarioDTO());
        }

        Pelicula p = peliculas.getPelicula(url_peli);
        model.addAttribute("pelicula", p);
        model.addAttribute("comentarios", comentarios.getComentarios(p));

        return "pelicula";
    }

    @GetMapping("/{url_peli}/borrar")
    public String borra(@PathVariable String url_peli) {
        peliculas.borrar(peliculas.getPelicula(url_peli));
        return "redirect:/portada";
    }

    @PostMapping(value = "/{url_peli}", params = "estrellas")
    public String estrellas(@PathVariable String url_peli, @RequestParam(value = "estrellas", defaultValue = "0", required = true) int estrellas) {
        Pelicula p = peliculas.getPelicula(url_peli);
        p.setSumaVotos(p.getSumaVotos() + estrellas);
        p.setnVotos(p.getnVotos() + 1);
        peliculas.modificar(p, p);
        return "redirect:/pelicula/" + url_peli;
    }

    @PostMapping(value = "/{url_peli}")
    public String comentario(ModelMap model, @PathVariable String url_peli, @ModelAttribute("comentarioDTO") @Valid ComentarioDTO cDTO, BindingResult errores) {
        String url = "pelicula";

        if (!errores.hasErrors()) {
            url = "redirect:/" + url + "/" + url_peli;
            Comentario c = new Comentario();
            c.setPelicula(peliculas.getPelicula(url_peli));
            c.setUsuario(sesion.getUsuario());
            c.setTitulo(cDTO.getTitulo());
            c.setTexto(cDTO.getTexto());
            c.setFecha(new Date());
            comentarios.insertar(c);
            model.clear();
        }

        //si hay errores no hacer redirect
        return url;
    }

    @PostMapping("/crear")
    public String crear(ModelMap model, @ModelAttribute("peliculaDTO") @Valid PeliculaDTO pDTO, BindingResult errores) {
        String url = "redirect:/portada";

        if (!errores.hasErrors()) {
            try {
                url = "redirect:/pelicula/" + pDTO.getUrl();

                Pelicula p = new Pelicula();
                p.setTitulo(pDTO.getTitulo());
                p.setUrl(pDTO.getUrl());
                p.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(pDTO.getFecha()));
                p.setFoto(pDTO.getFoto());
                p.setGenero(pDTO.getGenero());
                peliculas.insertar(p);
            } catch (ParseException ex) {
                Logger.getLogger(PeliculaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return url;
    }
}
