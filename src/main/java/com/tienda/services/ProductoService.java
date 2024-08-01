
package com.tienda.services;

import com.tienda.domain.Producto;
import java.util.List;


public interface ProductoService {
    //Se obtiene los registro de la tabla producto en un ArrayList 
    //de objetos Producto, todos o sólo los activos
    public List<Producto> getProductos(boolean activos);
    
    //Consulta1 
    public List<Producto> consulta1(double precioInf, double precioSup);
    //Consulta2
    public List<Producto> consulta2(double precioInf, double precioSup);
    
    //Consulta3
    public List<Producto> consulta3(double precioInf, double precioSup);
    
    
    //Recuperar el registro de la tabla producto en un objeto Producto
    // si el idProducto existe.. sino devuelve null
    public Producto getProducto(Producto producto);
    
    
    //Actualiza un registro en la tabla producto si el IdProducto existe
    //Crea un registro en la tabla producto si id Producto no tiene vlaor
    public void save(Producto producto);
    
    //Elimina el registro de la tabla producto si idProducto existe en la tabla
    public void delete (Producto producto);
}



