package es.mercadona.eanlookup.domain.dto;

import es.mercadona.eanlookup.domain.dto.activity.Activity;
import es.mercadona.eanlookup.domain.dto.item.Item;
import es.mercadona.eanlookup.domain.dto.supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EAN {

	private String EAN;
	
	private Item item;
	private Supplier supplier;
	private Activity destination;
}
