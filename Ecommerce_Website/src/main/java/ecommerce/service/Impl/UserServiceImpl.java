package ecommerce.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.UserRequestDTO;
import ecommerce.DTO.UserResponseDTO;
import ecommerce.entity.User;
import ecommerce.exceptions.AlreadyExistException;
import ecommerce.exceptions.ResourceNotFoundException;
import ecommerce.repository.UserRepository;
import ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	@Override
	public ApiResponse createUser(UserRequestDTO userDto) {
	
		// check if user is already exist or not
		User dbuser = this.userRepository.findByEmail(userDto.getEmail());
		ApiResponse apiResponse= new ApiResponse();
		try {
		if(dbuser != null){
			throw new AlreadyExistException("This user is already exist in database. Please try with another user");
			}else {
		
		User user = this.modelMapper.map(userDto, User.class);
		User savedUser = this.userRepository.save(user);
	    apiResponse.setMessage("User Created Successfully");
		}}
		catch(Exception e)
		{
			e.printStackTrace();
			apiResponse.setMessage("User is already exist in database. Please try with another user");
		}
		return apiResponse;
	}



	@Override
	public UserResponseDTO getSingleUser(Integer userId) {
		// check user is exist or not
		User  user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User ", " Id", userId));
		return this.modelMapper.map(user, UserResponseDTO.class);
	}



	@Override
	public List<UserResponseDTO> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserResponseDTO> responseDto=new ArrayList();
		for(User u: users)
		{
			UserResponseDTO userResponseDTO = this.modelMapper.map(u, UserResponseDTO.class);
			responseDto.add(userResponseDTO);
		}
		return responseDto;
	}



	@Override
	public ApiResponse deleteUser(Integer userId) {
		//check userId is already exist or not
		User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ", " Id", userId));
		this.userRepository.delete(user);
		return new ApiResponse("User deleted Successfully");
	}



	@Override
	public ApiResponse updateUser(UserRequestDTO userDto, Integer userId) {
		// check userId is exist or not
		User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ", " Id", userId));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		this.userRepository.save(user);
		return new ApiResponse("User created successfully");
	}


}
