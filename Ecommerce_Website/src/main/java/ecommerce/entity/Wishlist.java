//package ecommerce.entity;
//
//import java.util.Date;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Wishlist {
//	
//	public Wishlist(Product product) {
//		this.product=product;
//		this.createdDate=new Date();
//		
//	}
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	
//	@OneToOne(targetEntity = User.class, fetch=FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private User user;
//	
//	private Date createdDate;
//	
//	@ManyToOne
//	@JoinColumn(name="product_id")
//	private Product product;
//	
//
//}
