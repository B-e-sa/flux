package project.flux.api.v1.controllers.common.exceptions;

public class BadRequestException extends ApiRequestException {
	public BadRequestException() {
		super("Malformed request");
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}
