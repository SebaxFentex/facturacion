package com.prueba.facturacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.Perfil;
import com.prueba.facturacion.repositorio.PerfilRepositorio;

@RestController
@RequestMapping("/perfiles")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilControlador {
    
    @Autowired
    private PerfilRepositorio perfilRepositorio;

    @GetMapping("")
    public List<Perfil> listarPerfiles(){
        return perfilRepositorio.findAll();
    }
}
