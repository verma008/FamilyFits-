package ecommerce.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.CartRequestDTO;
import ecommerce.DTO.CartResponseDTO;
import ecommerce.DTO.CartResponseDTOS;
import ecommerce.entity.Cart;
import ecommerce.entity.Product;
import ecommerce.exceptions.ApiMessageException;
import ecommerce.exceptions.ResourceNotFoundException;
import ecommerce.repository.CartRepository;
import ecommerce.repository.ProductRepository;
import ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ApiResponse addToCart(CartRequestDTO cartDto) {
		System.out.println("before");
		// validate if the product id is valid
		Product  product = this.productRepository.findById(cartDto.getProductId()).orElseThrow(()-> new ResourceNotFoundException("Product ", " Id", cartDto. getProductId()));
		
		// save the cart
		Cart  cart = this.modelMapper.map( cartDto, Cart.class);
		cart.setCreatedDate(new Date());
		this.cartRepository.save(cart);
		System.out.println("before");
		return new ApiResponse("Added to Cart");
	}

	
	@Override
	public CartResponseDTOS getCartItems(Integer userId)
	{
		List<Cart> cartList= this.cartRepository.findAllByUserIdOrderByCreatedDateDesc(userId);
		List<CartResponseDTO> cartItems=new ArrayList<>();
		double totalCost=0;
		for(Cart cart:cartList)
		{
			CartResponseDTO cartResponseDTO=new CartResponseDTO(cart);
			totalCost+=cartResponseDTO.getQuantity() * cart.getProduct().getPrice();
			cartItems.add(cartResponseDTO);
		}
		CartResponseDTOS cartResponseDTOS =new CartResponseDTOS();
		cartResponseDTOS.setCartItems(cartItems);
		cartResponseDTOS.setTotalCost(totalCost);
		return cartResponseDTOS;
	}


	@Override
	public ApiResponse deleteCartItem(Integer cartId, Integer userId){
		
	    //the item id belongs to user
		Cart  cart = this.cartRepository.findById(cartId).orElseThrow(()-> new ResourceNotFoundException("Cart "," Id" , cartId));
		
		if(cart.getUserId()!=userId)
		{
			throw new ApiMessageException("Cart item does not belong to user: "+userId);
		}
		
		cartRepository.delete(cart);
		return new ApiResponse("Item has been removed");
		
	}

}
