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
import www.daas.com.py.models.Pago;
import www.daas.com.py.sessionbeans.PagoFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("pago")
public class PagoREST{
    
    @EJB
    PagoFacade pagoFacade;

    public PagoREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Pago entity) {
        pagoFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Pago entity) {
        pagoFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        pagoFacade.remove(pagoFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Pago find(@PathParam("id") Integer id) {
        return pagoFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Pago> findAll() {
        return pagoFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Pago> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return pagoFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(pagoFacade.count());
    }
    
}
