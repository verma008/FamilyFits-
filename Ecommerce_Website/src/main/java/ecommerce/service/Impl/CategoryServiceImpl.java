package ecommerce.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CategoryRequestDTO;
import ecommerce.DTO.CategoryResponseDTO;
import ecommerce.entity.Category;
import ecommerce.exceptions.AlreadyExistException;
import ecommerce.exceptions.ResourceNotFoundException;
import ecommerce.repository.CategoryRepository;
import ecommerce.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public ApiResponse createCategory(CategoryRequestDTO categoryDto) {
		
		//check category is already exist or not
		Category dbCategory = this.categoryRepository.findByCategoryName(categoryDto.getCategoryName());
        Category category = this.modelMapper.map(categoryDto, Category.class);
        ApiResponse apiResponse=new ApiResponse();
       try {
       if(dbCategory!=null)
       {
    	   throw new AlreadyExistException("This category is already exist. please create another category");
       }else {
       Category savedCategory = this.categoryRepository.save(category);
       apiResponse.setMessage("Category created successfully");
	         }
       }
       catch(AlreadyExistException e)
       {
		e.printStackTrace();
		apiResponse.setMessage("This category is already exist. please create another category");
       }catch(Exception e)
       {
    	   e.printStackTrace();
    	   apiResponse.setMessage("Unknown error occured please connect with teck team...");
       }
       return apiResponse;
       }

	@Override
	public List<CategoryResponseDTO> getAllCategories() {
	List<Category> categories = this.categoryRepository.findAll();
	List<CategoryResponseDTO> list = categories.stream().map((category)->this.modelMapper.map(category, CategoryResponseDTO.class)).collect(Collectors.toList());
	return list;
	}

	
	
	@Override
	public CategoryResponseDTO getSingleCategory(Integer categoryId) {
    Category  category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", " Id", categoryId));
    return this.modelMapper.map(category, CategoryResponseDTO.class);
	}
	
	
	
	@Override
	public ApiResponse deleteCategory(Integer categoryId) {
		//check category exist or not
		Category  category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ", " Id", categoryId));
		this.categoryRepository.delete(category);
		return new ApiResponse("Category deleted successfully");
	}
	
	

	@Override
	public ApiResponse updateCategory(CategoryRequestDTO categoryDto, Integer categoryId) {
		//check id exist or not
		Category  category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", " Id", categoryId));
		category.setCategoryName(categoryDto.getCategoryName());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setImageUrl(categoryDto.getImageUrl());
		this.categoryRepository.save(category);
		return new ApiResponse("Category updated successfully");
	}
}
