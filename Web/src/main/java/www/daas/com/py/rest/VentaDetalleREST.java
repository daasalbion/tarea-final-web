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
import www.daas.com.py.models.VentaDetalle;
import www.daas.com.py.sessionbeans.VentaDetalleFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("ventadetalle")
public class VentaDetalleREST{
    @EJB
    VentaDetalleFacade ventaDetalleFacade;

    public VentaDetalleREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(VentaDetalle entity) {
        ventaDetalleFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, VentaDetalle entity) {
        ventaDetalleFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        ventaDetalleFacade.remove(ventaDetalleFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public VentaDetalle find(@PathParam("id") Integer id) {
        return ventaDetalleFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<VentaDetalle> findAll() {
        return ventaDetalleFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<VentaDetalle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return ventaDetalleFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(ventaDetalleFacade.count());
    }
}
