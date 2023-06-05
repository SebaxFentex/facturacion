package com.prueba.facturacion.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoEncontrado extends RuntimeException{
    
    private static final long serialVersionUID = 1L;

    public NoEncontrado(String mensaje){
        super(mensaje);
    }
}
