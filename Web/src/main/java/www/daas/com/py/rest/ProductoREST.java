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
import www.daas.com.py.models.Producto;
import www.daas.com.py.sessionbeans.ProductoFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("producto")
public class ProductoREST{
    @EJB
    ProductoFacade productoFacade;

    public ProductoREST() {
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Producto entity) {
        productoFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Producto entity) {
        productoFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        productoFacade.remove(productoFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Producto find(@PathParam("id") Integer id) {
        return productoFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Producto> findAll() {
        return productoFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Producto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return productoFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(productoFacade.count());
    }
}
