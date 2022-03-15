
package com.ina.sysVentas.controller;

import com.ina.sysVentas.domain.Cliente;
import com.ina.sysVentas.services.IClienteService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class ClientesController {

    @Autowired
    private IClienteService servicioCliente;
    
    @GetMapping("/clientes")
    public String listar(Model model){
        List<Cliente> lista = servicioCliente.listar();
        model.addAttribute("clientes", lista);
        return "listaClientes";
    }
    
    @PostMapping("/filtrarClientes")
    public String filtrar(String txtTexto, Model model){
        List<Cliente> lista = servicioCliente.listar(txtTexto, txtTexto);
        model.addAttribute("clientes", lista);
        return "listaClientes";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevo(Cliente cliente){
        return "cliente";
    }
    
    @PostMapping("/guardarCliente")
    public String Guardar(@Valid Cliente cliente, Errors er){
      
        if(er.hasErrors()){
            return "cliente";
        }else{
            servicioCliente.guardar(cliente);
            return "redirect:/clientes";
        }
    }
    
    @GetMapping("/eliminarCliente")
    public String eliminar(Cliente cliente, Model model,RedirectAttributes red){
        int resultado= servicioCliente.eliminar(cliente);
        String msj="";
        if(resultado==0){
            msj="No se puede eliminar porque tiene venas asociadas";
        }else {
            msj="Cliente eliminado";
        }   
        red.addFlashAttribute("msj",msj);
        return "redirect:/clientes";
    }
    
    @GetMapping("/editarCliente/{idCliente}")
    public String editar(Cliente cliente, Model model,RedirectAttributes red){
        
        cliente= servicioCliente.obtenerCliente(cliente.getIdCliente());
        if(cliente!=null){
            model.addAttribute("cliente",cliente);
            return "cliente";
        }
        String msj="No se logró cargar el cliente";
        red.addFlashAttribute("msj",msj);
        return "redirect:/clientes";
        
        
    }
}
