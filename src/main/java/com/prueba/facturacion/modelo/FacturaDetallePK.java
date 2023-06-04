package com.prueba.facturacion.modelo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class FacturaDetallePK implements Serializable{
    
    @Column(name = "CONSECUTIVO")
    private Integer consecutivo;

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public FacturaDetallePK(Integer consecutivo, Integer idProducto) {
        this.consecutivo = consecutivo;
        this.idProducto = idProducto;
    }
}
