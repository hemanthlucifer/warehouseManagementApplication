package com.application.warehouseManagement.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.application.warehouseManagement.model.OrderProduct;

import lombok.Getter;
import lombok.Setter;

public class GetOrderDTO {
	
	@Getter
	@Setter
	private UUID orderId;
	
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
