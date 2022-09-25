package es.mercadona.eanlookup.domain.dto.item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewItem {

	@NotNull
	Integer id;
	
	@NotNull
	@NotBlank
	@Size(max=55)
	String title;
	
	@NotBlank
	@Size(max=255)
	String description;
}
