package com.prueba.facturacion.tablas;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class tablaCliente {
    private Integer id;
    private Integer tipoIdentificacion;
    private String identificacion;
    private String razonSocial;
    private LocalDate fechaRegistro;
    private Character estado;
    // private List<tablaFactura> facturas;

    @Id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTipoIdentificacion() {
        return tipoIdentificacion;
    }
    public void setTipoIdentificacion(Integer tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public String getRazonSocial() {
        return razonSocial;
    }
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Character getEstado() {
        return estado;
    }
    public void setEstado(Character estado) {
        this.estado = estado;
    }
    // public List<tablaFactura> getFacturas() {
    //     return facturas;
    // }
    // public void setFacturas(List<tablaFactura> facturas) {
    //     this.facturas = facturas;
    // }
    
}
