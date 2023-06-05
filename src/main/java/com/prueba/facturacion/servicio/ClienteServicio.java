package com.prueba.facturacion.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.facturacion.entidad.Cliente;
import com.prueba.facturacion.repositorio.ClienteRepositorio;

@Service
public class ClienteServicio {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarClientes(){
        return clienteRepositorio.findAll();
    }

    public Cliente guardarCliente(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    public Cliente buscarPorId(Integer id){
        return clienteRepositorio.findById(id).get();
    }

    public Cliente actualizarCliente(Cliente cliente){
        return clienteRepositorio.save(cliente);
    }
}
