package project.flux.api.v1.controllers.common.exceptions;

import java.util.Map;

import lombok.Getter;

public class CustomValidationException extends ApiRequestException {
	@Getter
	private Map<String, String> fields;
	
	public CustomValidationException(String message, Map<String, String> fields) {
		super(message);
		this.fields = fields;
	}
	
	public CustomValidationException(Map<String, String> fields) {
		super("Malformed request");
		this.fields = fields;
	}
}
