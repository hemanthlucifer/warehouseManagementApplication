package com.application.warehouseManagement.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GetGoodownDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String location;
	
	@Getter
	@Setter
	private String goodownManager;
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private String goodownImage;
	
	

}

