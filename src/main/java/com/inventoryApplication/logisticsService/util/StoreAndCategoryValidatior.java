package com.inventoryApplication.logisticsService.util;

import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.inventoryApplication.logisticsService.exceptions.CategoryNotFoundException;
import com.inventoryApplication.logisticsService.exceptions.GoodownNotFoundException;
import com.inventoryApplication.logisticsService.exceptions.MessageCodes;
import com.inventoryApplication.logisticsService.exceptions.ProductNotFoundException;
import com.inventoryApplication.logisticsService.exceptions.StoreNotFoundException;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.model.GoodownProduct;
import com.inventoryApplication.logisticsService.model.Store;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.repository.ProductRepository;
import com.inventoryApplication.logisticsService.repository.StoreRepository;

@Component
public class StoreAndCategoryValidatior {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MessageSource messageSource;
	
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
			throw new GoodownNotFoundException(messageSource.getMessage(MessageCodes.goodownNotFound, null, LocaleContextHolder.getLocale()));
		}
		logger.info("goodownValidator completed");
	}
	
	public void validateStore(int storeId) {
		logger.info("validateStore started");
		Optional<Store> store = storeRepository.findById(storeId);
		if(store.isEmpty()) {
			logger.warn("NO store found with the given Id");
			throw new StoreNotFoundException(messageSource.getMessage(MessageCodes.storeNotFound, null,LocaleContextHolder.getLocale()));
		}
		logger.info("validateStore completed");
	}
	
	public void validateCategory(String categoryId) {
		logger.info("Validate category started");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			logger.warn("Category is not present");
			throw new CategoryNotFoundException(messageSource.getMessage(MessageCodes.categoryNotFound, null, LocaleContextHolder.getLocale()));
		}
		logger.info("Validate category completed");
		}
	
	public void validateProduct(String productId) {
		Optional<GoodownProduct> product = productRepository.findById(productId);
		if(product.isEmpty()||product==null) {
			logger.warn("No product with the given product id found");
			throw new ProductNotFoundException(messageSource.getMessage(MessageCodes.productNotFound, null, LocaleContextHolder.getLocale()));
		}
	}

}
