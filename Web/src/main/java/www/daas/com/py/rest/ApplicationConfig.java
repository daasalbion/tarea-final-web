/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.daas.com.py.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Cinthia
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(www.daas.com.py.rest.ClienteREST.class);
        resources.add(www.daas.com.py.rest.CompraDetalleREST.class);
        resources.add(www.daas.com.py.rest.CompraREST.class);
        resources.add(www.daas.com.py.rest.FacturacionREST.class);
        resources.add(www.daas.com.py.rest.OrdenCompraREST.class);
        resources.add(www.daas.com.py.rest.PagoREST.class);
        resources.add(www.daas.com.py.rest.ProductoREST.class);
        resources.add(www.daas.com.py.rest.ProveedorREST.class);
        resources.add(www.daas.com.py.rest.VentaDetalleREST.class);
        resources.add(www.daas.com.py.rest.VentaREST.class);
    }
    
}
