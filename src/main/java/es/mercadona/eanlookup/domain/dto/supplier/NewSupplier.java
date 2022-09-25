package es.mercadona.eanlookup.domain.dto.supplier;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewSupplier {

	@NotNull
	@Max(9999999)
	Integer id;
	
	@NotNull
	@NotBlank
	@Size(max=55)
	String title;
	
	@NotNull
	@NotBlank
	@Size(max=255)
	String address;
}
