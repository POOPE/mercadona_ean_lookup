package es.mercadona.eanlookup.domain.dto.barcode;

import es.mercadona.eanlookup.domain.dto.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Barcode {

	String barcode;
	Item item;
}
