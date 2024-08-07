
package com.tienda.services.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.services.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // se define como servicio una clase que espera llamados de usuarios y solo una instancia de esa producto
public class ProductoServiceImpl implements ProductoService{
    @Autowired //Funcion crear abjetos sin decirlo
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if(activos){
            //Solo quiero Productos activas 
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly=true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);}

    @Override
    @Transactional (readOnly=true)
    public List<Producto> consulta1(double precioInf, double precioSup) {
        return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    @Override
    @Transactional (readOnly=true)
    public List<Producto> consulta2(double precioInf, double precioSup) {
        return productoDao.consultaJPQL(precioInf, precioSup);
    }
    @Override
    @Transactional (readOnly=true)
    public List<Producto> consulta3(double precioInf, double precioSup) {
        return productoDao.consultaSQL(precioInf, precioSup);
    }
    
    @Override
    @Transactional (readOnly=true)
    public List<Producto> consulta4(String nombreProducto) {
        return productoDao.consulta4(nombreProducto);
    }
}
