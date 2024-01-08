package com.inventoryApplication.logisticsService.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StoreDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private String storeName;
	
	@Getter
	@Setter
	private String storeLocation;
	
	@Getter
	@Setter
	private int noOfOrderForStore;

}
