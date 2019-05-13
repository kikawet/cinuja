/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author lopez
 */
@Provider
public class CinujaValidationExceptionManager implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<Object> errors = new ArrayList<>();

        for (final ConstraintViolation<?> cv : e.getConstraintViolations()) {
            final String[] partes = cv.getPropertyPath().toString().split("\\.");

            Object m = new Object() {
                public String name = partes[partes.length - 1];
                public String msg = cv.getMessage();
            };

            errors.add(m);
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(errors).build();
    }
}
