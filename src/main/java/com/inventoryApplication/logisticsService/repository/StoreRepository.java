package com.inventoryApplication.logisticsService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryAppliction.logisticsService.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

	Store findByStoreName(String storeName);
	
}
