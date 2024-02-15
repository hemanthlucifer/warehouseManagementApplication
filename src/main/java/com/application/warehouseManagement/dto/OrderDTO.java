package com.application.warehouseManagement.dto;

import java.time.LocalDate;
import java.util.List;

import com.application.warehouseManagement.model.OrderProduct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class OrderDTO {
	
	@Getter
	@Setter
	private int storeId;
	
	@Getter
	@Setter
	private String goodownId;
	
	@Getter
	@Setter
	private LocalDate placedDate;
	
	@Getter
	@Setter
	private LocalDate receivedDate;
	
	@Getter
	@Setter
	private boolean isOntime;
	
	@Getter
	@Setter
	private String quality;
	
	@Getter
	@Setter
	private List<OrderProduct> orderProducts;

}
