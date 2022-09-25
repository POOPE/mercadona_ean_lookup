package es.mercadona.eanlookup.service.activity;

import es.mercadona.eanlookup.domain.entity.activity.ActivityEntity;
import es.mercadona.eanlookup.service.CrudService;

public interface ActivityService extends CrudService<ActivityEntity,Integer>{

	ActivityEntity findByReferenceCode(String referenceCode);
}
