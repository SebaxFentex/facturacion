package com.prueba.facturacion.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.FacturaDetalle;
import com.prueba.facturacion.repositorio.FacturaDetalleRepositorio;

@RestController
@RequestMapping("/venta")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaDetalleControlador {
    
    @Autowired
    private FacturaDetalleRepositorio facturaDetalleRepositorio;

    @PostMapping("/")
    public Iterable<FacturaDetalle> registrarVenta(@RequestBody Iterable<FacturaDetalle> listaProductos){
        return facturaDetalleRepositorio.saveAll(listaProductos);
    }
}
