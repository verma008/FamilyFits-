//package ecommerce.service.Impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import ecommerce.DTO.ProductResponseDTO;
//import ecommerce.entity.Wishlist;
//import ecommerce.repository.WishlistRepository;
//import ecommerce.service.ProductService;
//import ecommerce.service.WishlistService;
//
//@Service
//public class WishlistServiceImpl implements WishlistService{
//
//	@Autowired
//	private WishlistRepository wishlistRepository;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//
//	
//	
//	@Override
//	public void addToWishlist(Wishlist wishlist) {
//		this.wishlistRepository.save(wishlist);
//		
//	}
//
//
//	@Override
//	public List<ProductResponseDTO> getWishlistForUser(Integer userId) {
//		List<Wishlist> wishList=this.wishlistRepository.findAllByUserOrderByCreatedDateDesc(userId);
//		List<ProductResponseDTO> productResponseDTOs=new ArrayList<>();
//		for(Wishlist wishlist:wishList)
//		{
//		ProductResponseDTO productResponseDTO = this.modelMapper.map(wishlist, ProductResponseDTO.class);
//		productResponseDTOs.add(productResponseDTO);
//		}
//		return productResponseDTOs;
//	}
//	
//}
