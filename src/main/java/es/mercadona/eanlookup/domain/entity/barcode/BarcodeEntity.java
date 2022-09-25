package es.mercadona.eanlookup.domain.entity.barcode;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import es.mercadona.eanlookup.domain.entity.item.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BARCODE")
public class BarcodeEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1946527471352985054L;
	
	@Id
	private String barcode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private ItemEntity item;
	
	
}
