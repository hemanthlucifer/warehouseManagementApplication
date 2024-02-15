package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.Order;

public interface OrderRepository extends JpaRepository<Order,java.util.UUID> {

}
