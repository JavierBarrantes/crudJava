package com.ina.sysVentas.services;

import com.ina.sysVentas.domain.Cliente;
import java.util.List;

public interface IClienteService {
    public void guardar (Cliente client);
    public Integer eliminar(Cliente client);
    public List<Cliente> listar();
    public List<Cliente> listar(String nombre, String apellido);
    public List<Cliente> listar(double limite);
    public Cliente obtenerCliente(Long idCliente);
}
