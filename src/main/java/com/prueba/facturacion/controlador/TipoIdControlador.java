package com.prueba.facturacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.TipoIdentificacion;
import com.prueba.facturacion.repositorio.TipoIdentificacionRepositorio;

@RestController
@RequestMapping("/tiposId")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoIdControlador {
    
    @Autowired
    private TipoIdentificacionRepositorio tipoIdRepositorio;

    @GetMapping("")
    public List<TipoIdentificacion> listarClientes(){
        return tipoIdRepositorio.findAll();
    }
}
