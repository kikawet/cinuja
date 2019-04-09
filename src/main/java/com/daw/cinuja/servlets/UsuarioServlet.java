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
import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DAO.models.Usuario;
import com.daw.cinuja.DAO.qualifiers.DAOJDBC;
import java.io.IOException;
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
@WebServlet(name = "Usuario", urlPatterns = {"/perfil/*"})
public class UsuarioServlet extends HttpServlet {

    @Inject
    @DAOJDBC
    private UsuarioDAO usuarios;

    @Inject
    @DAOJDBC
    private PeliculaDAO peliculas;

    @Inject
    @DAOJDBC
    private ComentarioDAO comentarios;

    @Inject
    private Sesion sesion;

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

//        request.authenticate(response);
        sesion.setUsuario(usuarios.getUsuario(request.getRemoteUser()));

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

        if ("/salir".equals(request.getPathInfo())) {

            request.logout();
            request.getSession().invalidate();

            response.sendRedirect(request.getContextPath() + "/portada");
            return;
        }

        if ("/cc".equals(request.getPathInfo())) {

            String contr = request.getParameter("contrase");

            if (contr != null) {
                Usuario u = usuarios.getUsuario(sesion.getUsuario().getNick());
                u.setContrasena(contr);

                usuarios.modificar(usuarios.getUsuario(sesion.getUsuario().getNick()), u);

                request.logout();
                request.getSession().invalidate();

                response.sendRedirect(request.getContextPath() + "/portada");
                return;
            }

            request.getRequestDispatcher("/WEB-INF/jsp/contrasena.jsp").forward(request, response);

        } else {

            String user = sesion.getUsuario().getNick();

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
            request.getSession().setAttribute("perfil", usuarios.getUsuario(user));

            request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
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

        if (request.getPathInfo().contains("/borrar/comentario")) {
            int hashComentario = new Integer(request.getParameter("com"));
            int hashPelicula = new Integer(request.getParameter("pel"));
            //buscar con has y borrarlo

            //        ArrayList<Comentario> total = new ArrayList<>();
            Comentario com = null;
            List<Pelicula> pelis = peliculas.getPeliculas();

            for (Pelicula p : pelis) {
                List<Comentario> cmtrs = comentarios.getComentarios(p);
                if (cmtrs != null) {
//                ArrayList<Comentario> c = new ArrayList<>(comentarios.getComentarios(p));
//                for (int i = c.size() - 1; i >= 0; i--) {
//                    if (!c.get(i).getUsuario().getNick().equals(sesion.getUsuario().getNick())) {
//                        c.remove(i);
//                    }
//                }
                    for (Comentario cmtr : cmtrs) {
                        if (cmtr.getPelicula().getTitulo().hashCode() == hashPelicula && cmtr.getTexto().hashCode() == hashComentario) {
                            com = cmtr;
                            break;
                        }
                    }

                }

                if (com != null) {
                    break;
                }

            }

            comentarios.borrar(com);

            response.sendRedirect(request.getContextPath() + "/perfil");
            return;
        }

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
