package com.ina.sysVentas.domain;

//import java.io.Serializable;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class Cliente implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;
    
    @Column(name = "nombre")
    @NotEmpty(message="El Nombre es obligatorio")
    private String nombre;
    
    @NotEmpty(message="El Apellido es Obligatorio")
    private String apellido;
    
    @Column(unique = true)
    @Email(message="Debe ingresar un correo válido")
    @NotEmpty(message = "El Correo es Obligatorio")
    private String email;
    
    private String telefono;
    
    @Min(value=0, message="El límite de crédito debe ser superior o igual a cero")
    @Column(name="limite_credito")
    @NotNull(message="El Límite de Crédito es Obligatorio")
    private double limiteCredito;
    
    
}
