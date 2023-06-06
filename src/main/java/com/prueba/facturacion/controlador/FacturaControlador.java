package com.prueba.facturacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.Factura;
import com.prueba.facturacion.excepciones.NoEncontrado;
import com.prueba.facturacion.repositorio.FacturaRepositorio;

@RestController
@RequestMapping("/facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaControlador {
    
    @Autowired
    public FacturaRepositorio facturaRepositorio;

    @GetMapping("")
    public List<Factura> listarFacturas(){
        return facturaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarFactura(@PathVariable Integer id){
        Factura factura = facturaRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe la factura " + id));
        return ResponseEntity.ok(factura);
    }

    @PostMapping("/registrar")
    public Factura guardarFactura(@RequestBody Factura factura){
        return facturaRepositorio.save(factura);
    }
}
