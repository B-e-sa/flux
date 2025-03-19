package project.flux.api.v1.controllers.common.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class ApiException {
	private final String message;
	private final HttpStatus httpStatus;
	private final int statusCode;
	
	public ApiException(String message, HttpStatus httpStatus) {
		this.message = message;
		this.httpStatus = httpStatus;
		this.statusCode = httpStatus.value();
	}
}

