package ecommerce.DTO;

import ecommerce.entity.Cart;
import ecommerce.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDTO {
	
	
	private int id;
	private int quantity;
	private Product product;
	
public CartResponseDTO(Cart cart) {
		this.id=cart.getId();
		this.quantity=cart.getQuantity();
		this.setProduct(cart.getProduct());
	}

}
