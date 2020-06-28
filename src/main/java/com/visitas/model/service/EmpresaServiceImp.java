package com.visitas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visitas.model.dao.IEmpresaDao;
import com.visitas.model.dao.IRolDao;
import com.visitas.model.entities.Empresa;
import com.visitas.model.entities.Rol;


@Service
public class EmpresaServiceImp<T> implements IGenericService2<T> {
	
	@Autowired
	private IEmpresaDao empresaDao;
		
	@Transactional(readOnly = true)
	@Override
	public T findOne(Integer id) {		
		// TODO Auto-generated method stub
		return (T) empresaDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return (List<T>) empresaDao.findAll();
	}

	@Transactional
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub		
		empresaDao.save((Empresa)entity);		
	}
	
	@Transactional
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		empresaDao.delete((Empresa) entity);
		
	}

	@Transactional
	@Override
	public void deleteById(Integer entityId) {
		// TODO Auto-generated method stub
		empresaDao.deleteById(entityId);
	}

	

}
