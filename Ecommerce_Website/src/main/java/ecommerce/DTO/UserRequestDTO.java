package ecommerce.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRequestDTO {
	
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;

}
