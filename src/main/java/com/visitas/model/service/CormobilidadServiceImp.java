package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.ICormobilidadDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.Cormobilidad;
import com.visitas.model.entities.Rol;


@Service
public class CormobilidadServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private ICormobilidadDao cormobilidadDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) cormobilidadDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) cormobilidadDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		cormobilidadDao.save((Cormobilidad)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		cormobilidadDao.delete((Cormobilidad) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		cormobilidadDao.deleteById(entityId);
	}

	

}
