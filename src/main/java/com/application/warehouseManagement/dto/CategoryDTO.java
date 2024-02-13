package com.inventoryApplication.logisticsService.dto;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CategoryDTO {
	
	@Getter
	@Setter
	private String categoryId;
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private int goodownCapacity;
	
	@Getter
	@Setter
	private int occupiedCapacity;
	
	@Getter
	@Setter
	private int availableCapacity;

}
