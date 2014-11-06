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
import www.daas.com.py.models.Facturacion;
import www.daas.com.py.sessionbeans.FacturacionFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("facturacion")
public class FacturacionREST{
    @EJB
    FacturacionFacade facturacionFacade;

    public FacturacionREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Facturacion entity) {
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Facturacion entity) {
        facturacionFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        facturacionFacade.remove(facturacionFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Facturacion find(@PathParam("id") Integer id) {
        return facturacionFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Facturacion> findAll() {
        return facturacionFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Facturacion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return facturacionFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(facturacionFacade.count());
    }
}
