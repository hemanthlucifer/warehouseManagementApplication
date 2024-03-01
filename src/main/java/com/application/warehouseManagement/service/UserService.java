package com.application.warehouseManagement.service;

import org.springframework.data.domain.Page;

import com.application.warehouseManagement.dto.GetUserDTO;
import com.application.warehouseManagement.dto.UserDTO;
import com.application.warehouseManagement.model.Goodown;

public interface UserService {
	
	public UserDTO createUser(UserDTO userDTO);
	public void deleteUser(String userId);
	public GetUserDTO getUserById(String userId);
	public Page<Goodown> getAdminGoodowns(int pageNumber, int pageSize);

}
