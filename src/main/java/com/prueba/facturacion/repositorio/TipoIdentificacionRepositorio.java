package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.TipoIdentificacion;

public interface TipoIdentificacionRepositorio extends JpaRepository<TipoIdentificacion, Integer>{
    
}
