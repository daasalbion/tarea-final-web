/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.daas.com.py.rest;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import www.daas.com.py.models.Compra;
import www.daas.com.py.sessionbeans.CompraFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("compra")
public class CompraREST {
    
    @EJB
    CompraFacade compraFacade;

    public CompraREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Compra entity) {
        compraFacade.create(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Compra entity) {
        compraFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        compraFacade.remove(compraFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Compra find(@PathParam("id") Integer id) {
        return compraFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Compra> findAll() {
        return compraFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Compra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return compraFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(compraFacade.count());
    }    
}
