package com.application.warehouseManagement.dto;

import java.util.List;

import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.util.UserRoles;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetUserDTO {
	
	@Getter
	@Setter
	private String userId;
	
	@Getter
	@Setter
	private String userName;
	
	@Getter
	@Setter
	private UserRoles userRole;
	
	@Getter
	@Setter
	private List<Goodown> goodowns;

}
