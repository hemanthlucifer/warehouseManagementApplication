package com.application.warehouseManagement.dto;

import java.io.Serializable;

import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class GoodownProductDTO  {
	
	
	@Getter
	@Setter
	private String productId;
	
	
	@Getter
	@Setter
	private String productManufacturer;
	
	@Getter
	@Setter
	private String productVersion;
	
	@Getter
	@Setter
	private String productDescription;
	
	
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
