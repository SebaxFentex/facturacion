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

import com.prueba.facturacion.entidad.Cliente;
import com.prueba.facturacion.excepciones.NoEncontrado;
import com.prueba.facturacion.repositorio.ClienteRepositorio;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @GetMapping("")
    public List<Cliente> listarClientes(){
        return clienteRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer id){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el cliente " + id));
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("/registrar")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> modificarCliente(@PathVariable Integer id, @RequestBody Cliente detallesCliente){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el cliente " + id));
        
        cliente.setRazonSocial(detallesCliente.getRazonSocial());
        cliente.setIdentificacion(detallesCliente.getIdentificacion());
        cliente.setEstado(detallesCliente.getEstado());
        cliente.setFechaRegistro(detallesCliente.getFechaRegistro());

        Cliente clienteActualizado = clienteRepositorio.save(cliente);

        return ResponseEntity.ok(clienteActualizado);
    }
}
