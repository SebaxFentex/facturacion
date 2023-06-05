package com.prueba.facturacion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.facturacion.entidad.Usuario;
import com.prueba.facturacion.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    public Usuario buscarPorId(Integer id){
        return usuarioRepositorio.findById(id).get();
    }

    public Usuario actualizarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }
}
