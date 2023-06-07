package com.prueba.facturacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.Informe;
import com.prueba.facturacion.repositorio.InformeRepositorio;

@RestController
@RequestMapping("/informes")
@CrossOrigin(origins = "http://localhost:4200")
public class InformeControlador {
    
    @Autowired
    private InformeRepositorio informeRepositorio;

    @GetMapping("/5")
    public Informe informe5(){
        Informe informe5 = informeRepositorio.informe5();
        return informe5;
    }

    @GetMapping("/6")
    public Informe informe6(){
        Informe informe6 = informeRepositorio.informe6();
        return informe6;
    }
}
