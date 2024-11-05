package ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CartRequestDTO;
import ecommerce.DTO.CartResponseDTOS;
import ecommerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;

	
	//create cart api
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addToCart(@RequestBody CartRequestDTO cartDto)
	{
		ApiResponse response=this.cartService.addToCart(cartDto);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.CREATED);
	}
	
	// get all cart items for  a user  // the product that we have added should be on top by user
	@GetMapping("/{userId}")
	public ResponseEntity<CartResponseDTOS> getCartItems(@PathVariable Integer userId)
	{
		CartResponseDTOS cartItems=this.cartService.getCartItems(userId);
		return new ResponseEntity<CartResponseDTOS>(cartItems,HttpStatus.OK);
	}
	
	
	//delete a cart item for a user
	@DeleteMapping("/{cartId}/{userId}")
	public ResponseEntity<ApiResponse> deleteCartIteam(@PathVariable Integer cartId,@PathVariable Integer userId)
	{
		ApiResponse response=cartService.deleteCartItem(cartId,userId);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}

}
