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
import www.daas.com.py.models.Proveedor;
import www.daas.com.py.sessionbeans.ProveedorFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("proveedor")
public class ProveedorREST {
    
    @EJB
    ProveedorFacade proveedorFacade;

    public ProveedorREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Proveedor entity) {
        proveedorFacade.create(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Proveedor entity) {
        proveedorFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        proveedorFacade.remove(proveedorFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Proveedor find(@PathParam("id") Integer id) {
        return proveedorFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Proveedor> findAll() {
        return proveedorFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Proveedor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return proveedorFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(proveedorFacade.count());
    }    
}
