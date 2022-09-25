package es.mercadona.eanlookup.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractCrudService<T,I> implements CrudService<T,I> {

	protected JpaRepository<T,I> repo;
	protected ModelMapper mapper;
	
	protected <R extends JpaRepository<T,I>> AbstractCrudService(R repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	@Override
	public T findById(I id) {
		return repo.findById(id).get();
	}

	@Override
	public T create(T entity) {
		return repo.save(entity);
	}

	@Override
	public T update(I id, T entity) {
		T old = findById(id);
		mapper.map(entity, old);
		return repo.save(entity);
	}

	@Override
	public void delete(I id) {
		repo.deleteById(id);
	}

	@Override
	public List<T> findAll() {
		return repo.findAll();
	}

}
