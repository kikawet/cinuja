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
import com.daw.cinuja.DTO.ComentarioDTO;
import com.daw.cinuja.DTO.UsuarioDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lopez
 */
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

    @ModelAttribute("comentario")
    public ComentarioDTO getComentario() {
        return new ComentarioDTO();
    }

    @ModelAttribute("sesion")
    public Sesion getSesion() {
        return sesion;
    }

//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//
////        request.authenticate(response);
//        sesion.setUsuario(usuarios.getUsuario(request.getRemoteUser()));
//
//    }
    @ModelAttribute
    protected void processRequest(ModelMap model,HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        model.addAttribute("usuarioDTO", new UsuarioDTO());
    }

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

    @GetMapping("/borrar/comentario")
    public String borrarComentario(@RequestParam(value = "id", defaultValue = "0") Integer id, ModelMap model) {
        comentarios.borrar(comentarios.getComentarios(sesion.getUsuario()).get(id));
//        model.clear();
        return "redirect:/perfil";
    }

    @PostMapping("/modifica/comentario")
    public String modificarComentario(
            @ModelAttribute("comentario") @Valid ComentarioDTO cDTO, BindingResult errores,
            @RequestParam(value = "id", defaultValue = "0") Integer id, ModelMap model) {
        String url = "usuario";

        Comentario c = comentarios.getComentarios(sesion.getUsuario()).get(id);
        ComentarioDTO CDTO = new ComentarioDTO();
        CDTO.setTitulo(c.getTitulo());
        CDTO.setTexto(c.getTexto());
        
        if (cDTO.equals(CDTO)) {
            errores.rejectValue("titulo", "error.comentario.titulo", "No se ha modificado el titulo");
            errores.rejectValue("texto", "error.comentario.texto", "No se ha modificado el texto");
        }
            
        if (!errores.hasErrors()) {
            url = "redirect:/perfil";
            System.out.println("redirect");
            c.setTitulo(cDTO.getTitulo());
            c.setTexto(cDTO.getTexto());
            comentarios.modificar(c, c);            
        } else {
            model.addAttribute("comentarios", comentarios.getComentarios(sesion.getUsuario()));
            model.addAttribute("generos", PeliculaDAO.generos);
            model.addAttribute("perfil", sesion.getUsuario());
        }

        return url;
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping(value = "/registro")
    public String comentario(ModelMap model,
            @ModelAttribute("usuarioDTO") @Valid UsuarioDTO uDTO, BindingResult errores,
             @RequestParam(value = "contrasena2", defaultValue = "") String contrasena
    ) {
        String url = "registro";

        if (!uDTO.isTerminos()) {
            errores.rejectValue("terminos", "error.cliente.terminos", "Debes de aceptar los terminos de usuario");
        }

        if (!uDTO.getContrasena().equals(contrasena) || contrasena.isEmpty()) {
//            errores.rejectValue("contrasena", "error.cliente.contrasena", "Las contraseñas no son iguales");
            errores.addError(new FieldError("contrasena2", "contrasena2", "Las contraseñas no son iguales"));
        } else {
            model.addAttribute("contrasena2", contrasena);
        }

        if (usuarios.getUsuario(uDTO.getNick()) != null) {
            errores.rejectValue("nick", "error.cliente.nick", "Ya hay otro usuario con ese nick");
        }

        if (!errores.hasErrors()) {
            url = "redirect:/perfil";
            Usuario u = new Usuario();
            u.setNick(uDTO.getNick());
            u.setNombre(uDTO.getNombre());
            u.setApellidos(uDTO.getApellidos());
            u.setContrasena(uDTO.getContrasena());
            u.setFoto("http://scapp.ie20deenero.edu.co/assets/img/defaultcon.png");
            usuarios.insertar(u);
            model.clear();
        } else {
            List<Object> errs = new ArrayList<>();
//           Jsonb jsonb = JsonbBuilder.create();//te odio java 7

            for (FieldError e : errores.getFieldErrors()) {
                final String name = e.getField();
                final String msg = e.getDefaultMessage();
                String m = "{\"name\":\"" + name + "\",\"msg\":\"" + msg + "\"}";
//                Object m = new Object(){
//                  public String name = nam;
//                  public String msg = ms;
//                };

                errs.add(m);
            }
            model.addAttribute("errors", errs);
        }

        //si hay errores no hacer redirect
        return url;
    }

}
