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
import com.daw.cinuja.DAO.models.Sesion;
import com.daw.cinuja.DAO.models.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lopez
 */
//@WebServlet(name = "Usuario", urlPatterns = {"/perfil/*"})
@Controller
@RequestMapping("/perfil")
public class UsuarioController {

    @Autowired
    @Qualifier(UsuarioDAOJDBC.qualifier)
    private UsuarioDAO usuarios;

    @Autowired
    @Qualifier(PeliculaDAOJDBC.qualifier)
    private PeliculaDAO peliculas;

    @Autowired
    @Qualifier(ComentarioDAOJDBC.qualifier)
    private ComentarioDAO comentarios;

    @Autowired
    private Sesion sesion;

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
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
////        request.authenticate(response);
//        sesion.setUsuario(usuarios.getUsuario(request.getRemoteUser()));
//
//    }
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
//        if ("/salir".equals(request.getPathInfo())) {
//
//            request.logout();
//            request.getSession().invalidate();
//
//            response.sendRedirect(request.getContextPath() + "/portada");
//            return;
//        }
//
//        if ("/cc".equals(request.getPathInfo())) {
//
//            String contr = request.getParameter("contrase");
//
//            if (contr != null) {
//                Usuario u = usuarios.getUsuario(sesion.getUsuario().getNick());
//                u.setContrasena(contr);
//
//                usuarios.modificar(usuarios.getUsuario(sesion.getUsuario().getNick()), u);
//
//                request.logout();
//                request.getSession().invalidate();
//
//                response.sendRedirect(request.getContextPath() + "/portada");
//                return;
//            }
//
//            request.getRequestDispatcher("/WEB-INF/jsp/contrasena.jsp").forward(request, response);
//
//        } else {
//
//            String user = sesion.getUsuario().getNick();
//
//            ArrayList<Comentario> total = new ArrayList<>();
//
//            for (Pelicula p : peliculas.getPeliculas()) {
//                if (comentarios.getComentarios(p) != null) {
//                    ArrayList<Comentario> c = new ArrayList<>(comentarios.getComentarios(p));
//                    for (int i = c.size() - 1; i >= 0; i--) {
//                        if (!c.get(i).getUsuario().getNick().equals(user)) {
//                            c.remove(i);
//                        }
//                    }
//                    total.addAll(c);
//                }
//            }
//
//            request.getSession().setAttribute("comentarios", total);
//            request.getSession().setAttribute("generos", PeliculaDAO.generos);
//            request.getSession().setAttribute("perfil", usuarios.getUsuario(user));
//
//            request.getRequestDispatcher("/WEB-INF/jsp/usuario.jsp").forward(request, response);
//        }
//
//    }
    @GetMapping("")
    public String visualiza(ModelMap model, HttpServletRequest request) {
        sesion.setUsuario(usuarios.getUsuario(request.getRemoteUser()));
        model.addAttribute("comentarios", comentarios.getComentarios(sesion.getUsuario()));
        model.addAttribute("generos", PeliculaDAO.generos);
        model.addAttribute("perfil", sesion.getUsuario());

        return "usuario";
    }

    @GetMapping("/salir")
    public String salir(HttpSession session) {
        sesion.setUsuario(null);
        session.invalidate();
        return "redirect:/portada";
    }

    @GetMapping("/cc")
    public String visuzalizaCambiaContrasena() {
        return "contrasena";
    }

    @PostMapping("/cc")
    public String cambiaContrasena(@RequestParam(value = "contrase", required = true) String contra) {
        Usuario u = sesion.getUsuario();
        u.setContrasena(contra);
        usuarios.modificar(sesion.getUsuario(), u);
        return "redirect:salir";
    }

    @PostMapping("/borrar/comentario")
    public String borrarComentario(@ModelAttribute("comentario") Comentario c) {
        return "redirect:perfil";
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//
//        if (request.getPathInfo().contains("/borrar/comentario")) {
//            int hashComentario = new Integer(request.getParameter("com"));
//            int hashPelicula = new Integer(request.getParameter("pel"));
//            //buscar con has y borrarlo
//
//            //        ArrayList<Comentario> total = new ArrayList<>();
//            Comentario com = null;
//            List<Pelicula> pelis = peliculas.getPeliculas();
//
//            for (Pelicula p : pelis) {
//                List<Comentario> cmtrs = comentarios.getComentarios(p);
//                if (cmtrs != null) {
////                ArrayList<Comentario> c = new ArrayList<>(comentarios.getComentarios(p));
////                for (int i = c.size() - 1; i >= 0; i--) {
////                    if (!c.get(i).getUsuario().getNick().equals(sesion.getUsuario().getNick())) {
////                        c.remove(i);
////                    }
////                }
//                    for (Comentario cmtr : cmtrs) {
//                        if (cmtr.getPelicula().getTitulo().hashCode() == hashPelicula && cmtr.getTexto().hashCode() == hashComentario) {
//                            com = cmtr;
//                            break;
//                        }
//                    }
//
//                }
//
//                if (com != null) {
//                    break;
//                }
//
//            }
//
//            comentarios.borrar(com);
//
//            response.sendRedirect(request.getContextPath() + "/perfil");
//            return;
//        }
//
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Servlet para el perfil del usuario";
//    }// </editor-fold>
}
