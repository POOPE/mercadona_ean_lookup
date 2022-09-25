package es.mercadona.eanlookup.domain.entity.activity;

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
@Table(name = "ACTIVITY")
public class ActivityEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 787170979867168977L;
	
	@Id
	private Integer id = 0;
	
	private String title;
	
	private String referenceCode;
}
