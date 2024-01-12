package com.inventoryApplication.logisticsService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventoryApplication.logisticsService.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
	
	List<Category> findAllByGoodownId(String goodownId);

}
