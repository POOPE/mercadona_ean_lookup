package es.mercadona.eanlookup.domain.entity.item;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import es.mercadona.eanlookup.domain.entity.barcode.BarcodeEntity;
import es.mercadona.eanlookup.domain.entity.supplier.SupplierEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM")
public class ItemEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3550429946996496286L;

	@Id
	private Integer id = 0;

	private String title;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private SupplierEntity supplier;

	@OneToMany(mappedBy = "item", fetch = FetchType.LAZY)
	private Set<BarcodeEntity> barcodes;

}
