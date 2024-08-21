
package com.tienda.dao;

import com.tienda.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository es la interface que tiene la bd para poder realizar instrucciónes sin usar codígo sql
public interface RolDao extends JpaRepository<Rol,Long>{

}
