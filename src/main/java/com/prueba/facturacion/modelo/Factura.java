package com.prueba.facturacion.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FACTURAS")
public class Factura {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONSECUTIVO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CLIENTE")
    private Cliente cliente;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @OneToMany(mappedBy = "factura")
    private List<FacturaDetalle> facturas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Factura() {
    }

    public Factura(Integer id, Cliente cliente, LocalDate fecha, List<FacturaDetalle> facturas) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.facturas = facturas;
    }
}
