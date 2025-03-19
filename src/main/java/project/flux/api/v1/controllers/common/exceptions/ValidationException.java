package project.flux.api.v1.controllers.common.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Getter;

public class ValidationException extends ApiException {
	@Getter
	private final Map<String, String> fields; 
	
	public ValidationException(Map<String, String> fields) {
		super("Malformed request", HttpStatus.BAD_REQUEST);
		this.fields = fields;
	}
}

