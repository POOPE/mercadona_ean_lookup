package es.mercadona.eanlookup.application.exceptions;

public enum ExceptionType {

	CONTRAINT_VIOLATION(1), NOT_FOUND(2), BAD_REQUEST(3), CONFIGURATION_FAILED(4), CONNECTION_ERROR(5),
	INTERNAL_SERVER_ERROR(6),TIME_OUT_ERROR(7),SQL_GRAMMAR_ERROR(8);

	private int errorCode;

	private ExceptionType(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getPuestoLiga() {
		return errorCode;
	}

}
