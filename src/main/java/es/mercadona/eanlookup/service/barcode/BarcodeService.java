package es.mercadona.eanlookup.service.barcode;

import es.mercadona.eanlookup.domain.dto.EAN;
import es.mercadona.eanlookup.domain.entity.barcode.BarcodeEntity;
import es.mercadona.eanlookup.service.CrudService;

public interface BarcodeService extends CrudService<BarcodeEntity,String>{

	EAN findEAN(String EAN);
}
