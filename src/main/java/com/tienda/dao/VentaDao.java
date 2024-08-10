
package com.tienda.dao;

import com.tienda.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository es la interface que tiene la bd para poder realizar instrucciónes sin usar codígo sql
public interface VentaDao extends JpaRepository<Venta,Long>{
    
    
}
