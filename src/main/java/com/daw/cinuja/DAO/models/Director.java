/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.DAO.models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author lopez
 */
@ApplicationScoped
public class Director {

    @NotNull(message = "Un director necesita al menos el nombre")
    @Size(min = 3, max = 20, message = "El nombre del director tiene que estar entre {min} y {max} caracteres")
    private String nombre;
    @Past(message = "La fecha de nacimiento de un director debe ser anterior a la actual")
    private Calendar fnacimiento;
    @Pattern(regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]", message = "La foto debe ser de una url")
    private String foto;
    @Size(min = 5, max = 30, message = "Los apellidos de un director deben estar entre {min} y {max} caracteres")
    private String apellidos;
    @Size(min = 10, max = 256, message = "La biografia debe de tener una longitud de entre {min} y {max} caracteres")
    private String biografia;

    public Director() {
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Director other = (Director) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Calendar fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

}
