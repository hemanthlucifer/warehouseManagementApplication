package com.application.warehouseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.GoodownProduct;

@Repository
public interface ProductRepository extends JpaRepository<GoodownProduct,String> {
    
	List<GoodownProduct> findAllByGoodownId(Goodown goodownId);
	
	List<GoodownProduct> findAllByGoodownIdAndCategoryId(Goodown goodownId,Category categoryId);
	
}
