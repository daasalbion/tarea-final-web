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
import javax.ws.rs.core.MediaType;
import www.daas.com.py.models.Cliente;
import www.daas.com.py.sessionbeans.ClienteFacade;

/**
 *
 * @author Cinthia
 */
@Stateless
@Path("cliente")
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteREST{
    
    @EJB
    ClienteFacade clienteFacade;

    public ClienteREST() {
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Cliente entity) {
        clienteFacade.create(entity);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Cliente cliente) {
        clienteFacade.edit(cliente);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        clienteFacade.remove(clienteFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente find(@PathParam("id") Integer id) {
        return clienteFacade.find(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> findAll() {
        return clienteFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return clienteFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(clienteFacade.count());
    }
    
}
