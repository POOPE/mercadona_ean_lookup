package es.mercadona.eanlookup.service;

import java.util.List;

public interface CrudService<T,I> {
	
	T findById(I id);
	T create(T entity);
	T update(I id, T entity);
	void delete(I id);
	List<T> findAll();
}
