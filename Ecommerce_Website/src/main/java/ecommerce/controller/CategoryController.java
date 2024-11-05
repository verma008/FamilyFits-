package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CategoryRequestDTO;
import ecommerce.DTO.CategoryResponseDTO;
import ecommerce.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	//create category
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryRequestDTO categoryDto)
	{
		ApiResponse category = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<ApiResponse>(category,HttpStatus.CREATED);
	}
	
	// get all category 
	@GetMapping("/categories")
	public List<CategoryResponseDTO> getAllCategories(Model model){
		List<CategoryResponseDTO> allCategories = this.categoryService.getAllCategories();
		model.addAttribute("categories", allCategories);
        return allCategories; 
	}
	
	
	// API to get single category
	@GetMapping("/{categorId}")
	public CategoryResponseDTO getSingleCategory(@PathVariable Integer categoryId){
		return this.categoryService.getSingleCategory(categoryId);
	}
	
	
	// delete category
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
	{
		ApiResponse deletedCategory = this.categoryService.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(deletedCategory,HttpStatus.NOT_FOUND);
	}
	
	
	// update category
	@PutMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@RequestBody CategoryRequestDTO categoryDto, @PathVariable Integer categoryId){
		ApiResponse updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
		return new ResponseEntity<ApiResponse>(updatedCategory,HttpStatus.OK);	}
	
	
}

