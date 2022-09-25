package es.mercadona.eanlookup.service.activity;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.domain.entity.activity.ActivityEntity;
import es.mercadona.eanlookup.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityRepository repo;
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public ActivityEntity findById(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public ActivityEntity create(ActivityEntity entity) {
		return repo.save(entity);
	}

	@Override
	public ActivityEntity update(Integer id, ActivityEntity entity) {
		ActivityEntity old = findById(id);
		mapper.map(entity, old);
		return repo.save(old);
	}

	@Override
	public void delete(Integer id) {
		this.repo.deleteById(id);
	}

	@Override
	public ActivityEntity findByReferenceCode(String referenceCode) {
		return this.repo.findByReferenceCode(referenceCode).get();
	}

	@Override
	public List<ActivityEntity> findAll() {
		return this.repo.findAll();
	}

}
