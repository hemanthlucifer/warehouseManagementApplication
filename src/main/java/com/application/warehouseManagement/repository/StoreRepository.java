package com.application.warehouseManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

	Store findByStoreName(String storeName);
	
}
