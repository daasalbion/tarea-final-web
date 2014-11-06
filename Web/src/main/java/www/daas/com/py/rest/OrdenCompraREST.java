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
import www.daas.com.py.models.OrdenCompra;
import www.daas.com.py.sessionbeans.OrdenCompraFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("ordencompra")
public class OrdenCompraREST{
    
    @EJB
    OrdenCompraFacade ordenCompraFacade;

    public OrdenCompraREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(OrdenCompra entity) {
        ordenCompraFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, OrdenCompra entity) {
        ordenCompraFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ordenCompraFacade.remove(ordenCompraFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public OrdenCompra find(@PathParam("id") Integer id) {
        return ordenCompraFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<OrdenCompra> findAll() {
        return ordenCompraFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<OrdenCompra> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return ordenCompraFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(ordenCompraFacade.count());
    }
    
}
