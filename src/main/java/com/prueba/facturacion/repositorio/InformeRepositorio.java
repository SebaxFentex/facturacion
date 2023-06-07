package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.facturacion.entidad.Informe;

public interface InformeRepositorio extends JpaRepository<Informe, String>{
    String informe5 = """
        select mes, max(totalFacturado)
        from(
            select extract(month from f.fecha) as mes, sum(fd.valor_unitario) as totalFacturado, p.nombre as nombreProducto
            from facturas f
            inner join factura_detalle fd
            on f.consecutivo = fd.consecutivo
            inner join productos p
            on fd.id_producto = p.id
            group by mes, nombreProducto
            ) as subquery
        group by mes
    """;
    @Query(value = informe5, nativeQuery = true)
    public Informe informe5();

    
    String informe6 = """
            
            """;
    @Query(value = informe5, nativeQuery = true)
    public Informe informe6();
}
