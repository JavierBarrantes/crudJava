package com.ina.sysVentas.services;

import com.ina.sysVentas.dao.IProductoDao;
import com.ina.sysVentas.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoDao productoDao;
    
    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void eliminar(Producto producto) {
        productoDao.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar(String descripcion) {
        return (List<Producto>) productoDao.findByDescripcionContains(descripcion);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto obtenUno(Long id) {
        return productoDao.findById(id).orElse(null);
    }
    
    
}
