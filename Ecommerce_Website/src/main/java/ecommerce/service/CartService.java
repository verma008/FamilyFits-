package ecommerce.service;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CartRequestDTO;
import ecommerce.DTO.CartResponseDTOS;

public interface CartService {

	ApiResponse addToCart(CartRequestDTO cartDto);

	CartResponseDTOS getCartItems(Integer userId);

	ApiResponse deleteCartItem(Integer cartId,Integer userId);

}
