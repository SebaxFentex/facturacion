package com.prueba.facturacion.entidad;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOS_IDENTIFICACIONES")
public class TipoIdentificacion {

    @Id
    @Column(name = "TIPO_IDENTIFICACION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ABREVIATURA", length = 3)
    private String abreviatura;

    @Column(name = "DESCRIPCION", length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Cliente> clientes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Integer id, String abreviatura, String descripcion, List<Cliente> clientes) {
        this.id = id;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.clientes = clientes;
    }
}
