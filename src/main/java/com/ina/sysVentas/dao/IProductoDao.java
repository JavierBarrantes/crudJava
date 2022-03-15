package com.ina.sysVentas.dao;

import com.ina.sysVentas.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoDao extends JpaRepository<Producto, Long>{
    
    public Iterable<Producto> findByDescripcionContains(String descripcion);
}
