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
import ecommerce.DTO.UserRequestDTO;
import ecommerce.DTO.UserResponseDTO;
import ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	// two apis : sign-up and sign-in
		
	// sign-up
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createUser(@RequestBody UserRequestDTO userDto)
	{
		ApiResponse user = this.userService.createUser(userDto);
		return new ResponseEntity<ApiResponse>(user,HttpStatus.CREATED);
	}
	
	
	// api to get single user
	@GetMapping("/{userId}")
	public UserResponseDTO getSingleUser(@PathVariable Integer userId){
		return this.userService.getSingleUser(userId);
	}
	
	
	// api to get all user
	@GetMapping("/")
	public List<UserResponseDTO> getALLUsers()
	{
		return this.userService.getAllUsers();
	}
	
	
	// delete the user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId)
	{
		ApiResponse deletedUser = this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(deletedUser,HttpStatus.NOT_FOUND);
	}
	
	
	// update User
	@PutMapping("/{userId}")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody  UserRequestDTO userDto,@PathVariable Integer userId)
	{
		ApiResponse updatedUser = this.userService.updateUser(userDto,userId);
		return new ResponseEntity<ApiResponse>(updatedUser,HttpStatus.OK);
	}
	
	
	// sign-in
}
