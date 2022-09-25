package es.mercadona.eanlookup.domain.dto.supplier;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Supplier {

	@NotNull
	@NotBlank
	@Size(max=55)
	private String title;
	
	@NotBlank
	@Size(max=255)
	private String address;
}
