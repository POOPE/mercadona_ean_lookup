package es.mercadona.eanlookup.application.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

@Provider
@Component
public class GenericExceptionInterceptor implements ExceptionMapper<Exception> {
	@Override
	public Response toResponse(final Exception exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity(new ExceptionResponse(ExceptionType.INTERNAL_SERVER_ERROR, exception.getMessage())).build();
	}

}
