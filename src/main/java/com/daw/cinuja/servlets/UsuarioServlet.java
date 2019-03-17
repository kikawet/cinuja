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
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DAO.qualifiers.DAOList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Usuario", urlPatterns = {"/perfil"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    private Usuario usuario;

    @Inject
    private UsuarioDAO usuarios;

    @Inject
    private PeliculaDAO peliculas;

    @Inject
    @DAOList
    private ComentarioDAO comentarios;

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

        String user = "pescues";
        if (usuarios.getUsuario(user) != null) {
            usuario.setNick(usuarios.getUsuario(user).getNick());
            usuario.setFoto(usuarios.getUsuario(user).getFoto());
            usuario.setNombre(usuarios.getUsuario(user).getNombre());
        }

        ArrayList<Comentario> total = new ArrayList<>();

        for (Pelicula p : peliculas.getPeliculas()) {
            if (comentarios.getComentarios(p) != null) {
                ArrayList<Comentario> c = new ArrayList<>(comentarios.getComentarios(p));
                for (int i = c.size() - 1; i >= 0; i--) {
                    if (!c.get(i).getUsuario().getNick().equals(user)) {
                        c.remove(i);
                    }
                }
                total.addAll(c);
            }
        }

        request.getSession().setAttribute("comentarios", total);
        request.getSession().setAttribute("generos", PeliculaDAO.generos);

        request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
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
        return "Servlet para el perfil del usuario";
    }// </editor-fold>

}
