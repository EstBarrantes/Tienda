
package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //indicarle a la clase que va a ser clase controlador
public class IndexController {
    
    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String listado (Model model)
    {
        var productos=productoService.getProductos(false);
        model.addAttribute("productos",productos);
      return "index";  
    }
    
    
}
