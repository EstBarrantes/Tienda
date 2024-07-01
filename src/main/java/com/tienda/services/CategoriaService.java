
package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //Se obtiene los registro de la tabla categoria en un ArrayList 
    //de objetos Categoria, todos o sólo los activos
    public List<Categoria> getCategorias(boolean activos);
    
    //Recuperar el registro de la tabla categoria en un objeto Categoria
    // si el idCategoria existe.. sino devuelve null
    public Categoria getCategoria(Categoria categoria);
    
    
    //Actualiza un registro en la tabla categoria si el IdCategoria existe
    //Crea un registro en la tabla categoria si id Categoria no tiene vlaor
    public void save(Categoria categoria);
    
    //Elimina el registro de la tabla categoria si idCategoria existe en la tabla
    public void delete (Categoria categoria);
}



