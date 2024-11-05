package ecommerce.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartRequestDTO {
	
	private int id;
	private int productId;
	private int quantity;
    private int userId;
}
