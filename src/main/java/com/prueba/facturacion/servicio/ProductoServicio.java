package com.prueba.facturacion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.facturacion.entidad.Producto;
import com.prueba.facturacion.repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    public Producto guardarProducto(Producto producto){
        return productoRepositorio.save(producto);
    }

    public Producto buscarPorId(Integer id){
        return productoRepositorio.findById(id).get();
    }

    public Producto actualizarProducto(Producto producto){
        return productoRepositorio.save(producto);
    }
}
