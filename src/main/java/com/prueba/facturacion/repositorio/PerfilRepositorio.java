package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.Perfil;

public interface PerfilRepositorio extends JpaRepository<Perfil, Integer>{
    
}
