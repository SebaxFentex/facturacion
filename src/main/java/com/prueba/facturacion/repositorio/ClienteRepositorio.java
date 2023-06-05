package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
}
