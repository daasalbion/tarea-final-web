/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.daas.com.py.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import www.daas.com.py.models.CompraDetalle;
import www.daas.com.py.sessionbeans.CompraDetalleFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("compradetalle")
public class CompraDetalleREST {
    
    @EJB
    CompraDetalleFacade compraDetalleFacade;

    public CompraDetalleREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(CompraDetalle entity) {
        compraDetalleFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, CompraDetalle entity) {
        compraDetalleFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        compraDetalleFacade.remove(compraDetalleFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public CompraDetalle find(@PathParam("id") Integer id) {
        return compraDetalleFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<CompraDetalle> findAll() {
        return compraDetalleFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<CompraDetalle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return compraDetalleFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(compraDetalleFacade.count());
    }
    
}
