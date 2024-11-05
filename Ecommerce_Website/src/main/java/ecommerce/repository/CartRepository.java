package ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecommerce.entity.Cart;
import ecommerce.entity.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

	List<Cart> findAllByUserIdOrderByCreatedDateDesc(Integer userId);
}
