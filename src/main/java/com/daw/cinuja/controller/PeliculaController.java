/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.controller;

import com.daw.cinuja.DAO.JDBC.ComentarioDAOJDBC;
import com.daw.cinuja.DAO.JDBC.PeliculaDAOJDBC;
import com.daw.cinuja.DAO.JDBC.UsuarioDAOJDBC;
import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DTO.ComentarioDTO;
import java.io.IOException;
import java.util.Date;
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
//@WebServlet(name = "PeliculaController", urlPatterns = {"/pelicula/*"})
@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    @Autowired
    @Qualifier(PeliculaDAOJDBC.qualifier)
    private PeliculaDAO peliculas;

    @Autowired
    @Qualifier(ComentarioDAOJDBC.qualifier)
    private ComentarioDAO comentarios;

    @Autowired
    @Qualifier(UsuarioDAOJDBC.qualifier)
    private UsuarioDAO usuarios;

    @Autowired
    private Sesion sesion;

    public PeliculaController() {
    }

    @ModelAttribute("sesion")
    public Sesion getSesion() {
        return sesion;
    }

//    protected Pelicula getPelicula(HttpServletRequest request) {
//        Pelicula p = null;
//        int i = 0;
//        int index = request.getPathInfo().substring(1).indexOf("/");
//        String url = request.getPathInfo().substring(1);
//        if (index != -1) {
//            url = url.substring(0, index);
//        }
//        while (i < peliculas.getPeliculas().size() && p == null) {
//            if (url.equals(peliculas.getPeliculas().get(i).getUrl())) {
//                p = peliculas.getPeliculas().get(i);
//            }
//            i++;
//        }
//        return p;
//    }
//    protected void Stars(Pelicula p, int valoracion) {
//
//        p.setNota((p.getNota() + valoracion) / 2);
//    }
//    protected boolean Comentarios(HttpServletRequest request) {
//
//        String titulo = request.getParameter("titulo");
//        String texto = request.getParameter("comentario");
//
//        if (titulo == null) {
//            titulo = "";
//        }
//        if (texto == null) {
//            texto = "";
//        }
//
//        Comentario comentario = new Comentario();
//        Pelicula p = getPelicula(request);
//
//        comentario.setFecha(new Date());
////        comentario.getFecha().set(Calendar.MILLISECOND, 0);
//        comentario.setPelicula(p);
//        comentario.setUsuario(sesion.getUsuario());
//        comentario.setTitulo(titulo);
//        comentario.setTexto(texto);
//
//        Set<ConstraintViolation<Comentario>> errores = new TreeSet<>();//validator.validate(comentario);
//
////        Iterator<ConstraintViolation<Comentario>> it = errores.iterator();
////        while (it.hasNext()) {
////            ConstraintViolation<Comentario> next = it.next();
////            if (next.getPropertyPath().toString().equals("fecha")) {
////                it.remove();
////            }
////        }
//        errores.clear();
//        if (errores.isEmpty()) {
//            comentarios.insertar(comentario);
//            request.setAttribute("comentarios", comentarios.getComentarios(p));
//            return true;
//        } else {
//            request.setAttribute("titulo", titulo);
//            request.setAttribute("texto", texto);
//            request.setAttribute("errores", errores);
//            return false;
//        }
//
//    }
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
    protected void processRequest(@PathVariable String url_peli, HttpServletRequest request, HttpServletResponse response, ModelMap model)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
//        request.setCharacterEncoding("UTF-8");
        Pelicula p = peliculas.getPelicula(url_peli);
        model.addAttribute("pelicula", p);
        model.addAttribute("comentarios", comentarios.getComentarios(p));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//
//        Pelicula p = getPelicula(request);
//
//        if (("/" + p.getUrl() + "/borrar").equals(request.getPathInfo())) {
//
//            List<Comentario> cmtrs = comentarios.getComentarios(p);
//
//            for (Comentario cmtr : cmtrs) {
//                comentarios.borrar(cmtr);
//            }
//
//            peliculas.borrar(p);
//
//            response.sendRedirect(request.getContextPath() + "/portada");
//            return;
//        } else {
//
//            request.setAttribute("pelicula", p);
//            request.setAttribute("comentarios", comentarios.getComentarios(p));
//
//            request.getRequestDispatcher("/WEB-INF/jsp/pelicula.jsp").forward(request, response);
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//
//        String estrellas = request.getParameter("estrellas");
//        Pelicula p = getPelicula(request);
//        boolean pe = false;
//
//        if (estrellas == null) {
//            if (Comentarios(request)) {
//                pe = true;
//            }
//        } else {
//            Stars(p, new Integer(estrellas));
//            request.setAttribute("comentarios", comentarios.getComentarios(p));
//            pe = true;
//        }
//
//        request.setAttribute("pelicula", p);
//
//        if (pe) {
//            response.sendRedirect("/cinuja/pelicula/" + p.getUrl());
//            return;
//        }
//
//        request.getRequestDispatcher("/WEB-INF/jsp/pelicula.jsp").forward(request, response);
//    }
    @GetMapping("/{url_peli}")
    public String visualiza(ModelMap model, @PathVariable String url_peli) {

        if (sesion.getUsuario() != null) {
            model.addAttribute("comentarioDTO", new ComentarioDTO());
        }

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

}
