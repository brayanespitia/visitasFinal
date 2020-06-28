package com.visitas.model.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IUsuarioDao;
import com.visitas.model.entities.Rol;
import com.visitas.model.entities.Usuario;



@Service("jpaUserDetailsService")
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;

	private Logger logger = LoggerFactory.getLogger(JpaUserDetailsService.class);

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Usuario usuario =(Usuario) usuarioDao.findByUsername(username);
        
        if(usuario == null) {
        	System.out.println("usuario null");
        	return null;
        }
        
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        
        Rol role= usuario.getRol();
        	logger.info("Role: ".concat(role.getDescripcion()));
        	authorities.add(new SimpleGrantedAuthority(role.getDescripcion()));        	              
		return new User(usuario.getUsuario(), usuario.getClave(), true, true, true, true, authorities);
	}

}
