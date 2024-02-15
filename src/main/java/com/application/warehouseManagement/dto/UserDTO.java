package com.application.warehouseManagement.dto;


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
	private String role;

}