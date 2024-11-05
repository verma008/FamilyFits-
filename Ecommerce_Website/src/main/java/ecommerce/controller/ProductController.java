package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.ProductRequestDTO;
import ecommerce.DTO.ProductResponseDTO;
import ecommerce.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// Create Product
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductRequestDTO productDto)
	{
		ApiResponse product = this.productService.createProduct(productDto);
		return new ResponseEntity<ApiResponse>(product, HttpStatus.CREATED);
	}

	// api to get all product
	@GetMapping("/")
	public ResponseEntity<List<ProductResponseDTO>> getAllProduct()
	{
		List<ProductResponseDTO> product= this.productService.getAllProduct();
		return new ResponseEntity<List<ProductResponseDTO>>(product,HttpStatus.OK);
	}
	
	// get Single Product
	@GetMapping("/{productId}")
	private ProductResponseDTO getSingleProduct(@PathVariable Integer productId)
	{
		return this.productService.getSingleProduct(productId);
	}
	
	
	// delete product
		@DeleteMapping("/{productId}")
		public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Integer productId)
		{
			ApiResponse deleteProduct = this.productService.deleteProduct(productId);
			return new ResponseEntity<ApiResponse>(deleteProduct,HttpStatus.NOT_FOUND);
		}
		
		
		// update product
		@PutMapping("/productId")
		public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductRequestDTO productDto, @PathVariable Integer productId)
		{
			ApiResponse product = this.productService.updateProduct(productDto,productId);
			return new ResponseEntity<ApiResponse>(product,HttpStatus.OK);
		}
}
