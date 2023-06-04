package com.prueba.facturacion.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOMBRE", length = 100)
    private String nombre;

    @Column(name = "ESTADO", length = 45)
    private String estado;

    @Column(name = "VALOR_UNITARIO")
    private Integer valorUnitario;

    @OneToMany(mappedBy = "producto")
    private List<FacturaDetalle> facturas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Producto() {
    }

    public Producto(Integer id, String nombre, String estado, Integer valorUnitario, List<FacturaDetalle> facturas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.valorUnitario = valorUnitario;
        this.facturas = facturas;
    }
}
