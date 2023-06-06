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
import com.prueba.facturacion.repositorio.TipoIdentificacionRepositorio;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {
    
    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    @Autowired
    private TipoIdentificacionRepositorio tipoIdRepo;


    // Listar todos los clientes
    @GetMapping("")
    public List<Cliente> listarClientes(){
        return clienteRepositorio.findAll();
    }
    
    // Buscar un cliente por su llave primaria en la BD
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Integer id){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el cliente " + id));
        return ResponseEntity.ok(cliente);
    }

    // Buscar un cliente por la abreviatura de su tipo de documento y su numero de documento
    @GetMapping("/buscar/{abreviatura}-{identificacion}")
    public Cliente buscarClientePorIdentificacion(@PathVariable String abreviatura, @PathVariable String identificacion){
        Cliente cliente = clienteRepositorio.buscarCliente(identificacion, abreviatura);
        return cliente;
    }

    // REGISTRO
    @PostMapping("/registrar")
    public Cliente guardarCliente(@RequestBody Cliente cliente){
        return clienteRepositorio.save(cliente);
    }

    //ACTUALIZACION
    @PutMapping("/{id}")
    public Cliente modificarCliente(@PathVariable Integer id, @RequestBody Cliente detallesCliente){
        Cliente cliente = clienteRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el cliente " + id));
        
        // Para cambiar la llave foranea encontré dos opciones, mandar en el PUT "tipoIdentificacion": "localhost:8080/tiposId/N"
        // siendo N el tipoId a modificar, pero como tipoId no necesita controlador entonces la otra opción fue usar su repositorio
        // para buscar el objeto completo y guardarlo, 
        cliente.setTipoIdentificacion(tipoIdRepo.findById(detallesCliente.getTipoIdentificacion().getId()).get());

        cliente.setRazonSocial(detallesCliente.getRazonSocial());
        cliente.setIdentificacion(detallesCliente.getIdentificacion());
        cliente.setEstado(detallesCliente.getEstado());
        cliente.setFechaRegistro(detallesCliente.getFechaRegistro());

        // Cliente clienteActualizado = clienteRepositorio.save(cliente);

        return clienteRepositorio.save(cliente);
    }
}
