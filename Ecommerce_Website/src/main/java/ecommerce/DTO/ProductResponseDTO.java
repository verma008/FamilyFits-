package ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDTO {
	

	private int id;
	private String name;
	private String imageUrl;
	private double price;
	private String discription;
	private int categoryId;

}
