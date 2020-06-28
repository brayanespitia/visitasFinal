package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IBasicoDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.Basico;
import com.visitas.model.entities.Rol;


@Service
public class BasicoServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IBasicoDao basicoDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) basicoDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) basicoDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		basicoDao.save((Basico)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		basicoDao.delete((Basico) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		basicoDao.deleteById(entityId);
	}

	

}
