package com.application.warehouseManagement.dto;


import java.util.List;

import com.application.warehouseManagement.util.UserRoles;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDTO {
	
	@Getter
	@Setter
	private String emailId;
	
	@Getter
	@Setter
	private String userName;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	private UserRoles role;
	
	@Getter
	@Setter
	private List<String> goodownId;

}