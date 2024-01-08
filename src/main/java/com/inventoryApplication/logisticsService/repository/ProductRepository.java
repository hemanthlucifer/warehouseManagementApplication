package com.inventoryApplication.logisticsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryAppliction.logisticsService.model.GoodownProduct;

@Repository
public interface ProductRepository extends JpaRepository<GoodownProduct,String> {
    
	GoodownProduct findByGoodownId(String goodownId);
	
}
