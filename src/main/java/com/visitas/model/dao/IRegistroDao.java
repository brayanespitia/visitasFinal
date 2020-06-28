package com.visitas.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.visitas.model.entities.Registro;


public interface IRegistroDao extends CrudRepository <Registro, Integer>{

}
