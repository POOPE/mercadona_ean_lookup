package es.mercadona.eanlookup.application.security.jwt;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest  {
	
	@NotNull
	@Schema(description = "Username", example="admin")
	@JsonProperty("username")
	String username;
	
	@NotNull
	@Schema(description = "Password", example="admin")
	@JsonProperty("password")
	String password;
}
