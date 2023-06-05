package com.prueba.facturacion.entidad;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FacturaDetallePK implements Serializable{
    
    @Column(name = "CONSECUTIVO")
    private Integer idFactura;

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    public Integer getConsecutivo() {
        return idFactura;
    }

    public void setConsecutivo(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public FacturaDetallePK(Integer idFactura, Integer idProducto) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }
}
