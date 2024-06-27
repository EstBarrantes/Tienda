
package com.tienda.services.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // se define como servicio una clase que espera llamados de usuarios y solo una instancia de esa categoria
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired //Funcion crear abjetos sin decirlo
    private CategoriaDao categoriaDao;
    
    @Override
    public List<Categoria> getCategorias(boolean activos) {
        var lista = categoriaDao.findAll();
        if(activos){
            //Solo quiero Categorias activas 
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }
    
}
