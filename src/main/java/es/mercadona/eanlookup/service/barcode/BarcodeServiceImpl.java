package es.mercadona.eanlookup.service.barcode;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.mercadona.eanlookup.domain.dto.EAN;
import es.mercadona.eanlookup.domain.dto.Item;
import es.mercadona.eanlookup.domain.dto.Supplier;
import es.mercadona.eanlookup.domain.dto.activity.Activity;
import es.mercadona.eanlookup.domain.entity.activity.ActivityEntity;
import es.mercadona.eanlookup.domain.entity.barcode.BarcodeEntity;
import es.mercadona.eanlookup.domain.entity.item.ItemEntity;
import es.mercadona.eanlookup.domain.entity.supplier.SupplierEntity;
import es.mercadona.eanlookup.repository.BarcodeRepository;
import es.mercadona.eanlookup.service.AbstractCrudService;
import es.mercadona.eanlookup.service.activity.ActivityService;
import es.mercadona.eanlookup.service.item.ItemService;
import es.mercadona.eanlookup.service.supplier.SupplierService;

@Service
public class BarcodeServiceImpl extends AbstractCrudService<BarcodeEntity, String> implements BarcodeService {

	@Autowired
	ActivityService activityService;
	@Autowired
	SupplierService supplierService;
	@Autowired
	ItemService itemService;

	@Autowired
	protected BarcodeServiceImpl(BarcodeRepository repo, ModelMapper mapper) {
		super(repo, mapper);
	}

	@Override
	public EAN findEAN(String EAN) {
		EAN res = new EAN();
		String supplierCode = EAN.substring(0, 7);
		String itemCode = EAN.substring(7, 11);
		String activityCode = EAN.substring(12, 12);

		ActivityEntity activity = activityService.findByReferenceCode(activityCode);
		SupplierEntity supplier = supplierService.findById(Integer.valueOf(supplierCode.replaceFirst("^0+(?!$)", "")));
		ItemEntity item = itemService.findById(Integer.valueOf(itemCode.replaceFirst("^0+(?!$)", "")));
		
		res.setEAN(EAN);
		res.setDestination(mapper.map(activity, Activity.class));
		res.setSupplier(mapper.map(supplier, Supplier.class));
		res.setItem(mapper.map(item, Item.class));
		return null;
	}

}
