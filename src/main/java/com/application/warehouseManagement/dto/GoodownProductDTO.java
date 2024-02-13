package com.inventoryApplication.logisticsService.dto;

import java.io.Serializable;

import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GoodownProductDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	private String productId;
	
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private String categoryId;
	
	@Getter
	@Setter
	private int quantity;
	
	@Getter
	@Setter
	private int storeId; 
	
	

}
