package com.application.warehouseManagement.service;

import java.util.UUID;

import com.application.warehouseManagement.dto.GetOrderDTO;
import com.application.warehouseManagement.dto.OrderDTO;

public interface OrderService {
	
	public GetOrderDTO createOrder(OrderDTO order);
	public GetOrderDTO getOrder(UUID orderId);
	public GetOrderDTO updateQualityAndOntimeStatus(GetOrderDTO orderDTO);
	public void deleteOrder(UUID orderId);

}
