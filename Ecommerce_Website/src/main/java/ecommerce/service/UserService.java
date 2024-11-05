package ecommerce.service;

import java.util.List;

import ecommerce.DTO.ApiResponse;
import ecommerce.DTO.UserRequestDTO;
import ecommerce.DTO.UserResponseDTO;

public interface UserService {

	ApiResponse createUser(UserRequestDTO userDto);

	UserResponseDTO getSingleUser(Integer userId);

	List<UserResponseDTO> getAllUsers();

	ApiResponse deleteUser(Integer userId);

	ApiResponse updateUser(UserRequestDTO userDto, Integer userId);

}
