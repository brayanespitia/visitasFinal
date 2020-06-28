package com.visitas.model.service;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<T> extends Serializable{

	T findByUsername(String username);
	
	T findOne(Integer id);

	List<T> findAll();

	void save(T entity);

	void delete(T entity);

	void deleteById(Integer entityId);
}
