
package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//JpaRepository es la interface que tiene la bd para poder realizar instrucciónes sin usar codígo sql
public interface ProductoDao extends JpaRepository<Producto,Long>{
    
    //Una consulta ampliada por precio
    public List<Producto> findByPrecioBetweenOrderByDescripcion (double precioInf, double precioSup);
    
    //Una consulta ampliada por precio  mediante JPQL se refiere a la clase
    @Query(value="SELECT a FROM Producto a "
            + "WHERE a.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaJPQL (double precioInf, double precioSup);
    
    //Una consulta mediante SLQ se refiere a la tabla
    @Query(nativeQuery=true,
            value="SELECT * FROM producto a WHERE a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL (double precioInf, double precioSup);
    
    //Una consulta mediante SLQ se refiere a la tabla
    @Query(nativeQuery=true,
            value="SELECT * FROM producto a WHERE a.descripcion LIKE :nombreProducto ORDER BY a.descripcion ASC")
    public List<Producto> consulta4 (String nombreProducto);
    
  
}
