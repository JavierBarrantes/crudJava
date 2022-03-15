package com.ina.sysVentas.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name="Producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    private Long idProducto;
    
    @NotEmpty(message="La Descripción es obligatoria")
    private String descripcion;
    
    @NotNull(message="El Precio debe ser ingresado")
    private double precio;
    
    @NotNull(message="La Existencia es Requerida")
    private int existencia;
    
    public String toString(){
        return String.format("Producto: %s - %s",idProducto, descripcion);
    }
}
