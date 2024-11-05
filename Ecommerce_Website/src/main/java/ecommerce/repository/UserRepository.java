package ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ecommerce.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	public User findByEmail(String email);

}
