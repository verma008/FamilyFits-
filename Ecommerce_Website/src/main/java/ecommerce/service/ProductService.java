package ecommerce.service;

import java.util.List;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.ProductRequestDTO;
import ecommerce.DTO.ProductResponseDTO;

public interface ProductService {

	ApiResponse createProduct(ProductRequestDTO productDto);

	List<ProductResponseDTO> getAllProduct();

	ProductResponseDTO getSingleProduct(Integer productId);

	ApiResponse deleteProduct(Integer productId);

	ApiResponse updateProduct(ProductRequestDTO productDto, Integer productId);

}
