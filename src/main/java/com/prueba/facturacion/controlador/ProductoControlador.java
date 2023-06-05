package com.prueba.facturacion.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.facturacion.entidad.Producto;
import com.prueba.facturacion.excepciones.NoEncontrado;
import com.prueba.facturacion.repositorio.ProductoRepositorio;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoControlador {
    
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @GetMapping("/")
    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
        Producto producto = productoRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el producto " + id));
        return ResponseEntity.ok(producto);
    }

    @PostMapping("/registrar")
    public Producto guardarProducto(@RequestBody Producto producto){
        return productoRepositorio.save(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> modificarProducto(@PathVariable Integer id, @RequestBody Producto detallesProducto){
        Producto producto = productoRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el producto " + id));
        
        producto.setNombre(detallesProducto.getNombre());
        producto.setValorUnitario(detallesProducto.getValorUnitario());
        producto.setEstado(detallesProducto.getEstado());

        Producto productoActualizado = productoRepositorio.save(producto);

        return ResponseEntity.ok(productoActualizado);
    }
}
