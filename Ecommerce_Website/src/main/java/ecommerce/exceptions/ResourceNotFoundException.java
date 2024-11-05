package ecommerce.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private int fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
		super(resourceName+"not found with"+fieldName+" : "+fieldValue);
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}
