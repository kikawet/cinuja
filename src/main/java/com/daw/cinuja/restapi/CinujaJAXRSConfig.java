/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.cinuja.restapi;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author axpos
 */
@ApplicationPath("webservice")

public class CinujaJAXRSConfig extends ResourceConfig {

    public CinujaJAXRSConfig() {
        //Location of REST resource classes
        packages("com.daw.cinuja.restapi");
    }

}
