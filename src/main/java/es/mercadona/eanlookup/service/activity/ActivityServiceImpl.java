package es.mercadona.eanlookup.service.activity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.domain.entity.activity.ActivityEntity;
import es.mercadona.eanlookup.repository.ActivityRepository;
import es.mercadona.eanlookup.service.AbstractCrudService;

@Service
public class ActivityServiceImpl extends AbstractCrudService<ActivityEntity,Integer> implements ActivityService{

	@Autowired
	protected ActivityServiceImpl(ActivityRepository repo, ModelMapper mapper) {
		super(repo, mapper);

	}

	@Override
	public ActivityEntity findByReferenceCode(String referenceCode) {
		return ((ActivityRepository)repo).findByReferenceCode(referenceCode).get();
	}
	
	


}
