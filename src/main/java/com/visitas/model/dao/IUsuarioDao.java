package com.visitas.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.visitas.model.entities.Usuario;


public interface IUsuarioDao extends CrudRepository <Usuario, Integer>{
	public Usuario findByUsername(String usuario);
}
