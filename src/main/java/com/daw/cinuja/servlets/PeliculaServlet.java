/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.servlets;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author lopez
 */
@WebServlet(name = "PeliculaServlet", urlPatterns = {"/pelicula/*"})
public class PeliculaServlet extends HttpServlet {

    @Inject
    private PeliculaDAO peliculas;

    @Inject
    @DAOList
    private ComentarioDAO comentarios;

    @Inject
    private UsuarioDAO usuarios;

    @Inject
    private Validator validator;

    protected Pelicula getPelicula(HttpServletRequest request) {
        Pelicula p = null;
        int i = 0;
        while (i < peliculas.getPeliculas().size() && p == null) {
            if (request.getPathInfo().substring(1).equals(peliculas.getPeliculas().get(i).getUrl())) {
                p = peliculas.getPeliculas().get(i);
            }
            i++;
        }
        return p;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        Pelicula p = getPelicula(request);

        request.setAttribute("pelicula", p);
        request.setAttribute("comentarios", comentarios.getComentarios(p));

        request.getRequestDispatcher("/WEB-INF/jsp/pelicula.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String titulo = request.getParameter("titulo");
        String texto = request.getParameter("comentario");

        if (titulo == null) {
            titulo = "";
        }
        if (texto == null) {
            texto = "";
        }

        Comentario comentario = new Comentario();
        Pelicula p = getPelicula(request);

        comentario.setFecha(Calendar.getInstance());
//        comentario.getFecha().set(Calendar.MILLISECOND, 0);
        comentario.setPelicula(p);
        comentario.setUsuario(usuarios.getUsuario("pescues"));
        comentario.setTitulo(titulo);
        comentario.setTexto(texto);

        Set<ConstraintViolation<Comentario>> errores = validator.validate(comentario);

        Iterator<ConstraintViolation<Comentario>> it = errores.iterator();
        while (it.hasNext()) {
            ConstraintViolation<Comentario> next = it.next();
            if (next.getPropertyPath().toString().equals("fecha")) {
                it.remove();
            }
        }

        if (errores.isEmpty()) {
            comentarios.insertar(comentario);
            response.sendRedirect("/cinuja/pelicula/"+p.getUrl());
            return;
        } else {
            request.setAttribute("titulo", titulo);
            request.setAttribute("texto", texto);
            request.setAttribute("errores", errores);
        }

        request.setAttribute("pelicula", p);
        request.setAttribute("comentarios", comentarios.getComentarios(p));

        request.getRequestDispatcher("/WEB-INF/jsp/pelicula.jsp").forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
