//package ecommerce.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.system.ApplicationPid;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import ecommerce.DTO.ApiResponse;
//import ecommerce.DTO.ProductResponseDTO;
//import ecommerce.entity.Product;
//import ecommerce.entity.Wishlist;
//import ecommerce.service.WishlistService;
//
//@RestController
//@RequestMapping("/wishlist")
//public class WishlistController {
//
//	@Autowired
//	private WishlistService wishlistService;
//	
//	
////	save product as wishlist item
//	@PostMapping("add")
//    public ResponseEntity<ApiResponse> addToWishlist(@RequestBody Product product){
//		
//	
//		// authenticate the token   // find the user // save the item in wishlist
//		
//        Wishlist wishlist=new Wishlist(product);
//		wishlistService.addToWishlist(wishlist);
//		ApiResponse apiResponse=new ApiResponse("Addedd to wishlist");
//		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.CREATED);
//	}
//	
//	// get all wishlist item for a user
//	@GetMapping("/{userId}")
//	public ResponseEntity<List<ProductResponseDTO>> getWishlist(@PathVariable Integer userId)
//	{
//		// authenticate the token and find the user form token
//		List<ProductResponseDTO> wishlistForUser = this.wishlistService.getWishlistForUser(userId);
//		return new ResponseEntity<List<ProductResponseDTO>>(wishlistForUser,HttpStatus.OK);
//	}
//}
