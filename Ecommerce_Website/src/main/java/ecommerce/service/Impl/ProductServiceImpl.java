package ecommerce.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.ProductRequestDTO;
import ecommerce.DTO.ProductResponseDTO;
import ecommerce.entity.Category;
import ecommerce.entity.Product;
import ecommerce.exceptions.ResourceNotFoundException;
import ecommerce.repository.CategoryRepository;
import ecommerce.repository.ProductRepository;
import ecommerce.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public ApiResponse createProduct(ProductRequestDTO productDto) {

		// check if category is already exist or not
		Category category = this.categoryRepository.findById(productDto.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category ", " Id", productDto.getCategoryId()));
		Product product = this.modelMapper.map(productDto, Product.class);
		Product savedProduct = this.productRepository.save(product);
		return new ApiResponse("Product Created Successfully");
	}

	@Override
	public List<ProductResponseDTO> getAllProduct() {
		List<Product> products = this.productRepository.findAll();
		List<ProductResponseDTO> productResponse = new ArrayList<>();
		for (Product product : products) {
			ProductResponseDTO map = this.modelMapper.map(product, ProductResponseDTO.class);
			productResponse.add(map);
		}
		return productResponse;
	}

	@Override
	public ProductResponseDTO getSingleProduct(Integer productId) {
		// check product Id exist or not
		Product product = this.productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product ", " Id", productId));
		return this.modelMapper.map(product, ProductResponseDTO.class);
	}

	
	
	@Override
	public ApiResponse deleteProduct(Integer productId) {
		//check product Id exist or not
		Product product = this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product "," Id",productId));
		this.productRepository.delete(product);
		return new ApiResponse("Product deleted successfully");
	}

	@Override
	public ApiResponse updateProduct(ProductRequestDTO productDto, Integer productId) {
		//check productId exist or not
		Product product = this.productRepository.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product "," Id", productId));
		product.setName(productDto.getName());
		product.setImageUrl(product.getImageUrl());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDiscription());
		this.productRepository.save(product);
		return new ApiResponse("Product updated successfully");
	}
	
	
}
