package es.mercadona.eanlookup.service.barcode;

import es.mercadona.eanlookup.domain.dto.EAN;

public interface BarcodeService {

	EAN findEAN(String EAN);
}
