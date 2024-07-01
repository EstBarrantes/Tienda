
package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import com.tienda.services.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller //indicarle a la clase que va a ser clase controlador
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/listado")
    public String listado (Model model)
    {
        var lista=productoService.getProductos(false);
        model.addAttribute("productos",lista);
        model.addAttribute("totalProductos",lista.size());
      return "/producto/listado";  
    }
    
    @Autowired
    private FirebaseStorageService firebaseStorageService;
    
    @PostMapping("/guardar")
    public String guardar (Producto producto,
            @RequestParam("imagenFile")MultipartFile imagenFile){
        if (!imagenFile.isEmpty()){//Si se paso algo se guarda la imagen
            productoService.save(producto);
            String rutaImagen=firebaseStorageService
                    .cargaImagen (imagenFile,"producto",
                            producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/eliminar/{idProducto}")
    public String eliminar(Producto producto){
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }
    
    @GetMapping("/modificar/{idProducto}")
    public String modificar(Producto producto, Model model){
        producto=productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }
}
