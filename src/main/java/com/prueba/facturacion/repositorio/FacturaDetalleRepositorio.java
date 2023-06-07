package com.prueba.facturacion.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.facturacion.entidad.FacturaDetalle;
import com.prueba.facturacion.entidad.FacturaDetallePK;

public interface FacturaDetalleRepositorio extends JpaRepository<FacturaDetalle, FacturaDetallePK>{
}
