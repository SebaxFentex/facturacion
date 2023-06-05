package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
    public Usuario findByUsuario(String username);
}
