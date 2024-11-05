package ecommerce.exceptions;


public class AlreadyExistException extends RuntimeException {
	
	private String message;

	public AlreadyExistException(String message)
	{
		this.message=message;
	}
}
