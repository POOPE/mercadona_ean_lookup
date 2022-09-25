package es.mercadona.eanlookup.domain.entity.supplier;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "SUPPLIER")
public class SupplierEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5013721374456213089L;

	@Id
	private Integer id;

	private String title;

	private String address;

}
