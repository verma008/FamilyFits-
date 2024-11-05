package ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryResponseDTO {
	
	private int id;
	private String categoryName;
	private String categoryDescription;
	private String imageUrl;
}
