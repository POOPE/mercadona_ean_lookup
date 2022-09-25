package es.mercadona.eanlookup.service.item;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.domain.entity.item.ItemEntity;
import es.mercadona.eanlookup.repository.ItemRepository;
import es.mercadona.eanlookup.service.AbstractCrudService;

@Service
public class ItemServiceImpl extends AbstractCrudService<ItemEntity,Integer> implements ItemService{

	@Autowired
	protected ItemServiceImpl(ItemRepository repo, ModelMapper mapper) {
		super(repo, mapper);
	}

}
