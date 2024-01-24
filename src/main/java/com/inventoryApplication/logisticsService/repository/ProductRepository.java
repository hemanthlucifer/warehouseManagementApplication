package com.inventoryApplication.logisticsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.model.GoodownProduct;

@Repository
public interface ProductRepository extends JpaRepository<GoodownProduct,String> {
    
	List<GoodownProduct> findAllByGoodownId(Goodown goodownId);
	
}
