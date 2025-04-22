package project.flux.api.v1.controllers.common.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiRequestExceptionHandler {  
	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
    public ResponseEntity<Object> handleMessageNotReadableException(HttpMessageNotReadableException e) {
		ApiException apiException = new ApiException(
				"The request body is missing", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
	
	@ExceptionHandler(value = { BadRequestException.class })
    public ResponseEntity<Object> handleBadRequestException(BadRequestException e) {
		ApiException apiException = new ApiException(
				e.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
	
	@ExceptionHandler(value = { NotFoundException.class })
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
		ApiException apiException = new ApiException(
				e.getMessage(), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
	
	@ExceptionHandler(value = { ConflictException.class })
    public ResponseEntity<Object> handleConflictException(ConflictException e) {
		ApiException apiException = new ApiException(
				e.getMessage(), HttpStatus.CONFLICT);

        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }

	@ExceptionHandler(value = { CustomValidationException.class })
    public ResponseEntity<Object> handleCustomValidationException(CustomValidationException e) {
        ValidationException validationException = new ValidationException(e.getFields());
        return new ResponseEntity<>(validationException, validationException.getHttpStatus());
    }

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException e) {
    	Map<String, String> fields = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(field -> 
        	fields.put(field.getField(), field.getDefaultMessage()));
    	
        ValidationException validationException = new ValidationException(fields);

        return new ResponseEntity<>(validationException, validationException.getHttpStatus());
    }

    /*
    @ExceptionHandler(value = { Exception.class })
    public ResponseEntity<Object> handleUnknownException(Exception e) { 
    	ApiException apiException = new ApiException(
                "An unknown error ocurred: " + e.getMessage(), 
                HttpStatus.INTERNAL_SERVER_ERROR);
    	
        return new ResponseEntity<>(apiException, apiException.getHttpStatus());
    }
    */
}
