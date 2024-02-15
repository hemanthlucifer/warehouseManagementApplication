package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.warehouseManagement.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct,String>{

}
