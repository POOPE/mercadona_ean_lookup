package es.mercadona.eanlookup.domain.dto.activity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewActivity {

	@NotNull
	@Max(9)
	Integer id;

	@NotNull
	@NotBlank
	@Size(max = 55)
	String title;
	
	@Schema(description="Regular expression representing reference code to match",example="^[9]$")
	@NotNull
	@NotBlank
	@Size(max=55)
	String referenceCode;
}
