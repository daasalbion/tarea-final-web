/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.daas.com.py.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daasalbion
 */
@Entity
@Table(name = "compra_detalle", catalog = "postgres", schema = "tarea2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraDetalle.findAll", query = "SELECT c FROM CompraDetalle c"),
    @NamedQuery(name = "CompraDetalle.findByIdCompraDetalle", query = "SELECT c FROM CompraDetalle c WHERE c.idCompraDetalle = :idCompraDetalle"),
    @NamedQuery(name = "CompraDetalle.findByIdCompra", query = "SELECT c FROM CompraDetalle c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "CompraDetalle.findByCantidad", query = "SELECT c FROM CompraDetalle c WHERE c.cantidad = :cantidad")})
public class CompraDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_compra_detalle")
    private Integer idCompraDetalle;
    @Column(name = "id_compra")
    private Integer idCompra;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;

    public CompraDetalle() {
    }

    public CompraDetalle(Integer idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public Integer getIdCompraDetalle() {
        return idCompraDetalle;
    }

    public void setIdCompraDetalle(Integer idCompraDetalle) {
        this.idCompraDetalle = idCompraDetalle;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompraDetalle != null ? idCompraDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraDetalle)) {
            return false;
        }
        CompraDetalle other = (CompraDetalle) object;
        if ((this.idCompraDetalle == null && other.idCompraDetalle != null) || (this.idCompraDetalle != null && !this.idCompraDetalle.equals(other.idCompraDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "www.daas.com.py.models.CompraDetalle[ idCompraDetalle=" + idCompraDetalle + " ]";
    }
    
}
