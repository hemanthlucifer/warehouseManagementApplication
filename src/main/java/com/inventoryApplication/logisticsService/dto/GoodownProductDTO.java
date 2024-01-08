package com.inventoryApplication.logisticsService.dto;

import java.io.Serializable;

import com.inventoryAppliction.logisticsService.model.Goodown;


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
	private Goodown goodownId;
	
	@Getter
	@Setter
	private int  storageQuantity;
	
	@Getter
	@Setter
	private int actualQuantity;
	
	@Getter
	@Setter
	private int availableQuantity;

}
