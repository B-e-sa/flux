package project.flux.api.v1.controllers.common.exceptions;

public class ApiRequestException extends RuntimeException {
	public ApiRequestException(String message) {
		super(message);
	}
}

