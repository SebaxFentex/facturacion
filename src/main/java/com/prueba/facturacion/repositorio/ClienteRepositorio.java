package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.facturacion.entidad.Cliente;


public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{
    String consulta = """
    SELECT c.*
    FROM clientes c
    INNER JOIN tipos_identificaciones ti
    ON c.tipo_identificacion = ti.tipo_identificacion
    WHERE c.identificacion = :identificacion AND ti.abreviatura = :abreviatura
    """;

    @Query(value = consulta, nativeQuery = true)
    public Cliente buscarCliente(@Param("identificacion") String identificacion, @Param("abreviatura") String abreviatura);
}
