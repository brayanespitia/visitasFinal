package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IAccesoVisitanteDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.AccesoVisitante;
import com.visitas.model.entities.Rol;


@Service
public class AccesoVisitanteServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IAccesoVisitanteDao accesoVisitanteDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) accesoVisitanteDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) accesoVisitanteDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		accesoVisitanteDao.save((AccesoVisitante)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		accesoVisitanteDao.delete((AccesoVisitante) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		accesoVisitanteDao.deleteById(entityId);
	}

	

}
