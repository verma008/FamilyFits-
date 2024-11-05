package ecommerce.service;

import java.util.List;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CategoryRequestDTO;
import ecommerce.DTO.CategoryResponseDTO;


public interface CategoryService {
	
	public ApiResponse createCategory(CategoryRequestDTO categoryDto);

	public List<CategoryResponseDTO> getAllCategories();

	public CategoryResponseDTO getSingleCategory(Integer categoryId);

	public ApiResponse deleteCategory(Integer categoryId);

	public ApiResponse updateCategory(CategoryRequestDTO categoryDto, Integer categoryId);
}
