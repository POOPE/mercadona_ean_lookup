package es.mercadona.eanlookup.application.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
		info = @Info(
				title = "Mercadona EAN Lookup API", 
				description = "EAN Lookup API", 
				contact = @Contact(
						name = "Manager", 
						url = "https://mercadona.es", 
						email = "manager@mercadona.es")), 
		servers = @Server(url = "http://localhost:8080/api/eanlookup",description="Local host"))
@SecurityScheme(
		  name = "JWT", 
		  scheme = "bearer",
		  bearerFormat= "JWT",
		  type = SecuritySchemeType.HTTP,
		  in = SecuritySchemeIn.HEADER)
class OpenApiConfiguration {
}
