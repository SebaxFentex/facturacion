package com.prueba.facturacion.entidad;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURA_DETALLE")
public class FacturaDetalle {
    
    @EmbeddedId
    private FacturaDetallePK facturaDetallePK;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("id")
    @JoinColumn(name = "CONSECUTIVO")
    private Factura factura;

    @ManyToOne(cascade = CascadeType.MERGE)
    @MapsId("id")
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "VALOR_UNITARIO")
    private Integer valorUnitario;

}
