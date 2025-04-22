package project.flux.api.v1.controllers.common.exceptions;

public class ConflictException extends ApiRequestException {
	public ConflictException() {
		super("This resource already exists");
	}
	
	public ConflictException(String message) {
		super(message);
	}
}
