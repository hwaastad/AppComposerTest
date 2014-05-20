/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.web.war.service;

import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.waastad.ejb.jar.ejb.BusinessBeanLocal;

/**
 * REST Web Service
 *
 * @author helge
 */
@Path("services")
public class ServicesResource {

    @Context
    private UriInfo context;

    @EJB
    private BusinessBeanLocal businessBeanLocal;

    /**
     * Creates a new instance of ServicesResource
     */
    public ServicesResource() {
    }

    /**
     * Retrieves representation of an instance of
     * org.waastad.web.war.service.ServicesResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public Response getJson() {
        return Response.ok().entity(businessBeanLocal.sayHello()).build();
    }

}
