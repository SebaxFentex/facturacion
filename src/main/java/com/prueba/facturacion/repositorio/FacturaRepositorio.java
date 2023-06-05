package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer>{
    
}
