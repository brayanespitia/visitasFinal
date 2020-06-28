package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IAccesoDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.Acceso;
import com.visitas.model.entities.Rol;


@Service
public class AccesoServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IAccesoDao accesoDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) accesoDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) accesoDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		accesoDao.save((Acceso)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		accesoDao.delete((Acceso) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		accesoDao.deleteById(entityId);
	}

	

}
