package com.ina.sysVentas.dao;

import com.ina.sysVentas.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface IClienteDao extends JpaRepository<Cliente,Long>{
    
    //Método Personalizado Spring Data
    public Iterable<Cliente> findByNombreContainsOrApellidoContains(String nom, String ape);
    
    @Query(value = "Select c From Cliente c Where limite_credito >=?1")
    public Iterable<Cliente> buscarPorLimites(double limite);
    
    @Procedure(name="ELIMINAR_CLIENTE",outputParameterName="res")
    Integer eliminar_Cliente(@Param("ID")long id);
  
   
}
