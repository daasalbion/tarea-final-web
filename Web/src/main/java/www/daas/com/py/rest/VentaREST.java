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
import www.daas.com.py.models.Venta;
import www.daas.com.py.sessionbeans.VentaFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("venta")
public class VentaREST {
    
    @EJB
    VentaFacade ventaFacade;

    public VentaREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Venta entity) {
        ventaFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Venta entity) {
        ventaFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ventaFacade.remove(ventaFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Venta find(@PathParam("id") Integer id) {
        return ventaFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Venta> findAll() {
        return ventaFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Venta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return ventaFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(ventaFacade.count());
    }

}
