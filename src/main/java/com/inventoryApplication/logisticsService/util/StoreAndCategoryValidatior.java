package com.inventoryApplication.logisticsService.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(StoreAndCategoryValidatior.class);
	
	public void validate(String categoryId,int storeId){
		logger.info("validate started");
		Optional<Store> store = storeRepository.findById(storeId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(!store.isEmpty()&&!category.isEmpty()) {
			logger.warn("No category or store found");
		}
		logger.info("validate completed");
	}
	
	public void goodownValidator(String goodownId) {
		logger.info("goodownValidator started");
		Goodown goodown = goodownRepository.findByGoodownId(goodownId);
		if(goodown==null) {
			logger.warn("No goodown found with the given goodown id");
		}
		logger.info("goodownValidator completed");
	}
	
	public void validateStore(int storeId) {
		logger.info("validateStore started");
		Optional<Store> store = storeRepository.findById(storeId);
		if(store.isEmpty()) {
			logger.warn("NO store found with the given Id");
		}
		logger.info("validateStore completed");
	}

}
