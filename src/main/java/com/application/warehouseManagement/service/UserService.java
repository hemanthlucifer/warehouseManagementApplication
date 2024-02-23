package com.application.warehouseManagement.service;

import com.application.warehouseManagement.dto.GetUserDTO;
import com.application.warehouseManagement.dto.UserDTO;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	public void deleteUser(String userId);
	public GetUserDTO getUserById(String userId);

}
