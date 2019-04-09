/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.servlets;

import com.daw.cinuja.DAO.interfaces.ComentarioDAO;
import com.daw.cinuja.DAO.interfaces.PeliculaDAO;
import com.daw.cinuja.DAO.interfaces.UsuarioDAO;
import com.daw.cinuja.DAO.list.Init;
import com.daw.cinuja.DAO.models.Comentario;
import com.daw.cinuja.DAO.models.Pelicula;
import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DAO.qualifiers.DAOJDBC;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lopez
 */
@WebServlet(name = "Controller", urlPatterns = {"/portada/*"})
public class ControllerServlet extends HttpServlet {

    @Inject
    @DAOJDBC
    private PeliculaDAO peliculas;

    @Inject
    @DAOJDBC
    private UsuarioDAO usuarios;

    @Inject
    @DAOJDBC
    private ComentarioDAO comentarios;

    @Inject
    private Sesion sesion;

//    @Inject
//    private Init datosListas;
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

        request.setCharacterEncoding("UTF-8"); //Accept UTF-8 parameters

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

        if ("/registro".equals(request.getPathInfo())) {
            request.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(request, response);
        } else {

            request.getSession().setAttribute("generos", PeliculaDAO.generos);

            List<Pelicula> p = new ArrayList<>(peliculas.getPeliculas());
            String genero = request.getParameter("genero");

            if (genero != null) {
                int hashGenero = new Integer(genero);
                for (int i = p.size() - 1; i >= 0; i--) {
                    if (PeliculaDAO.generos.get(p.get(i).getGenero()).hashCode() != hashGenero) {
                        p.remove(i);
                    }
                }
            }

            request.setAttribute("peliculas", p);

            request.getRequestDispatcher("/WEB-INF/jsp/portada.jsp").forward(request, response);

        }
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet que controla la portada";
    }// </editor-fold>

}
