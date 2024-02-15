package com.application.warehouseManagement.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.OrderGroup;

public interface OrderGroupRepository extends JpaRepository<OrderGroup,Integer> {
	
	List<String> findAllProductIdByOrderId(UUID orderId);

}
