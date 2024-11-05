package ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ecommerce.DTO.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(AlreadyExistException.class)
	public ResponseEntity<ApiResponse> alreadyExistExceptionHandler(AlreadyExistException exception)
	{
		String message = exception.getMessage();
		ApiResponse apiResponse=new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resouceNotFoundExceptionHandler(ResourceNotFoundException exception)
	{
		String message = exception.getMessage();
		ApiResponse apiResponse=new ApiResponse(message);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ApiMessageException.class)
	public ResponseEntity<String> apiMessageExceptionHandler(ApiMessageException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
