package es.mercadona.eanlookup.service.supplier;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.domain.entity.supplier.SupplierEntity;
import es.mercadona.eanlookup.repository.SupplierRepository;
import es.mercadona.eanlookup.service.AbstractCrudService;

@Service
public class SupplierServiceImpl extends AbstractCrudService<SupplierEntity,Integer> implements SupplierService {

	@Autowired
	protected SupplierServiceImpl(SupplierRepository repo, ModelMapper mapper) {
		super(repo, mapper);
	}

}
