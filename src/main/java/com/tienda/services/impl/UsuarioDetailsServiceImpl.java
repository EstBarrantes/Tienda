
package com.tienda.services.impl;

import com.tienda.dao.UsuarioDao;
import com.tienda.domain.Rol;
import com.tienda.domain.Usuario;
import com.tienda.services.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("userDetailsService")
public class UsuarioDetailsServiceImpl 
        implements UsuarioDetailsService, UserDetailsService {
    
    @Autowired 
    private UsuarioDao usuarioDao;
    
    @Autowired 
    private HttpSession session;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca el registro en la tabla usuario que tenga el username pasado por prm
        Usuario usuario = usuarioDao.findByUsername(username);
        
        //se valida si el usuario se encontró
        if (usuario==null){
        //No se encontró el usuario
        throw new UsernameNotFoundException(username);
    }
        //Si estamos acá... entonces si se encontró el usuario
        //Debemos cargar la foto del usuario
        session.removeAttribute("imagenUsuario");
        session.setAttribute("imagenUsuario", usuario.getRutaImagen());
        
        //Se deben crear los roles que vienen desde la tabla rol..
        var roles= new ArrayList<GrantedAuthority>();
       
        //Se recorren los roles del usuario y se pasan al arreglo.. ya como rol de seguridad
        for(Rol r: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(),roles);
        
    }
    
 
}
