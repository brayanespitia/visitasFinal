package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IRegistroDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.Registro;
import com.visitas.model.entities.Rol;


@Service
public class RegistroServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IRegistroDao registroDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) registroDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) registroDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		registroDao.save((Registro)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		registroDao.delete((Registro) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		registroDao.deleteById(entityId);
	}

	

}
