package com.prueba.facturacion.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURA_DETALLE")
@IdClass(FacturaDetallePK.class)
public class FacturaDetalle {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "CONSECUTIVO")
    private Factura factura;

    @Id
    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "VALOR_UNITARIO")
    private Integer valorUnitario;

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

    public FacturaDetalle() {
    }

    public FacturaDetalle(Factura factura, Producto producto, Integer cantidad, Integer valorUnitario) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }
}
