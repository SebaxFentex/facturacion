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

import com.prueba.facturacion.entidad.Usuario;
import com.prueba.facturacion.excepciones.NoEncontrado;
import com.prueba.facturacion.repositorio.UsuarioRepositorio;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @GetMapping("/")
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el usuario " + id));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/registrar")
    public Usuario guardarUsuario(@RequestBody Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> modificarUsuario(@PathVariable Integer id, @RequestBody Usuario detallesUsuario){
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new NoEncontrado("No existe el usuario " + id));

        usuario.setNombre(detallesUsuario.getNombre());
        usuario.setApellido(detallesUsuario.getApellido());
        usuario.setUsuario(detallesUsuario.getUsuario());
        usuario.setContrasena(detallesUsuario.getContrasena());
        
        Usuario usuarioActualizado = usuarioRepositorio.save(usuario);

        return ResponseEntity.ok(usuarioActualizado);
    }
}
