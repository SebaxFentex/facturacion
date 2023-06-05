package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
