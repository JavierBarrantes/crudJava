package com.ina.sysVentas.services;

import com.ina.sysVentas.domain.Producto;
import java.util.List;

public interface IProductoService {
    public void guardar (Producto producto);
    public void eliminar(Producto producto);
    public Producto obtenUno(Long id);
    public List<Producto> listar();
    public List<Producto> listar(String descripcion);
}
