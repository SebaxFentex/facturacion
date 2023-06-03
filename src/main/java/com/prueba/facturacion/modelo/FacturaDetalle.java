package com.prueba.facturacion.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURA_DETALLE")
public class FacturaDetalle {
    
    @EmbeddedId
    private FacturaDetallePK id;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "VALOR_UNITARIO")
    private Integer valorUnitario;

    public FacturaDetallePK getId() {
        return id;
    }

    public void setId(FacturaDetallePK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
}
