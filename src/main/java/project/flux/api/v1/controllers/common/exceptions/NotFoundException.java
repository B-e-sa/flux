package project.flux.api.v1.controllers.common.exceptions;

public class NotFoundException extends ApiRequestException {
	public NotFoundException() {
		super("Resource was not found");
	}

	public NotFoundException(String message) {
		super(message);
	}
}
