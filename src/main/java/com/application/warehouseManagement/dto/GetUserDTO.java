package com.application.warehouseManagement.dto;

import java.util.List;

import com.application.warehouseManagement.model.Goodown;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetUserDTO {
	
	@Getter
	@Setter
	private UserDTO userDto;
	
	@Getter
	@Setter
	private List<Goodown> goodowns;

}
