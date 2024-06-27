
package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //Se obtiene los registro de la tabla categoria en un ArrayList 
    //de objetos Categoria, todos o sólo los activos
    public List<Categoria> getCategorias(boolean activos);
}
