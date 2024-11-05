package ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
	
	private int id;
	private String name;
	private String imageUrl;
	private double price;
	private String discription;
	
	private int categoryId;
	

}
