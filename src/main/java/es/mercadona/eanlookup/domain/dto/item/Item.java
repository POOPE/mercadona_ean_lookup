package es.mercadona.eanlookup.domain.dto.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Item {

	@NotNull
	@NotBlank
	@Size(max=55)
	private String title;
	
	@NotBlank
	@Size(max=255)
	private String description;
}
