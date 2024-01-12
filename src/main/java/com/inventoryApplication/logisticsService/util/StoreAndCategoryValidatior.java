package com.inventoryApplication.logisticsService.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.model.Store;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.repository.StoreRepository;

@Component
public class StoreAndCategoryValidatior {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	public void validate(String categoryId,int storeId) throws Exception {
		Optional<Store> store = storeRepository.findById(storeId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(!store.isEmpty()&&!category.isEmpty()) {
			throw new Exception();
		}
	}
	
	public void goodownValidator(String goodownId) {
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			
		}
	}

}
