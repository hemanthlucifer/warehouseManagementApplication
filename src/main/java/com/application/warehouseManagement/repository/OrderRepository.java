package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.WarehouseOrder;

public interface OrderRepository extends JpaRepository<WarehouseOrder,java.util.UUID> {

}
