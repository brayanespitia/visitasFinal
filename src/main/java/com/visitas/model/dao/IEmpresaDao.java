package com.visitas.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.visitas.model.entities.Empresa;


public interface IEmpresaDao extends CrudRepository <Empresa, Integer>{

}
