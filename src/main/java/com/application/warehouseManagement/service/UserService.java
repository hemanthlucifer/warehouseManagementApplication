package com.application.warehouseManagement.service;

import com.application.warehouseManagement.dto.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	public void deleteUser(String userId);
	public UserDTO getUserById(String userId);

}
