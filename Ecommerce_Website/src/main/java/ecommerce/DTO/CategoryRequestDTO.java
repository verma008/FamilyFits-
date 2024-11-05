package ecommerce.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequestDTO {
	
	private int id;
	private String categoryName;
	private String categoryDescription;
	private String imageUrl;

}
