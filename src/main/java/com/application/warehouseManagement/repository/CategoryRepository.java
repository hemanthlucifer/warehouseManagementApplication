package com.application.warehouseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String> {
	
	List<Category> findAllByGoodownId(Goodown goodownId);

}
