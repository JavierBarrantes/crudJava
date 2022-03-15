package com.ina.sysVentas.controller;

import com.ina.sysVentas.domain.Producto;
import com.ina.sysVentas.services.IProductoService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductosController {
    
    @Autowired
    private IProductoService productoService;
    
    @GetMapping("/productos")
    public String listar(Model model){
        List<Producto> list = productoService.listar();
        model.addAttribute("productos", list);
        return "listaProductos";
    }
    @PostMapping("/filtrarProductos")
    public String filtrar(String txtTexto, Model model){
        List<Producto> lista = productoService.listar(txtTexto);
        model.addAttribute("productos", lista);
        return "listaProductos";
    }
    
    @GetMapping("/nuevoProducto")
    public String nuevo(Producto producto){
        return "Producto";
    }
    
    @PostMapping("/guardarProducto")
    public String Guardar(@Valid Producto producto, Errors er,RedirectAttributes red){
        String msj="";
        if(er.hasErrors()){
            return "Producto";
        }else{
             productoService.guardar(producto);
             msj="Producto almacenado de manera exitosa";
             red.addFlashAttribute("msj",msj);
            return "redirect:/productos";
        }
    }
    
    @GetMapping("/eliminarProducto")
    public String eliminar(Producto producto, Model model,RedirectAttributes red){
        String msj;
        productoService.eliminar(producto);
        producto=productoService.obtenUno(producto.getIdProducto());
       if(producto==null){
            msj="Producto eliminado";
        }else {
            msj="No se pudo eliminar el producto";
        }
        red.addFlashAttribute("msj",msj);
        return "redirect:/productos";
    }
    
    @GetMapping("/editarProducto/{idProducto}")
    public String editar(Producto producto, Model model,RedirectAttributes red){     
        producto= productoService.obtenUno(producto.getIdProducto());
         String msj="";
        if(producto!=null){
            msj="Se actulizo con exito";
            model.addAttribute("producto",producto);
            return "producto";
        }
         msj="No se logró cargar el Producto";
        red.addFlashAttribute("msj",msj);
        return "redirect:/productos";   
    }
    
}
