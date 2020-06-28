package com.visitas.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.visitas.model.entities.Visitante;


public interface IVisitanteDao extends CrudRepository <Visitante, Integer>{

}
