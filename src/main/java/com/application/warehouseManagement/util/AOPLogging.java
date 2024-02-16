package com.application.warehouseManagement.util;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.application.warehouseManagement.dto.GoodownProductDTO;

@Aspect
@Component
public class AOPLogging {
	
	private static final Logger logger = LoggerFactory.getLogger(AOPLogging.class);
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.createCategory(com.application.warehouseManagement.dto.CategoryDTO))")
	public void createcategoryLogging() {
		logger.info("Create category method started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.createCategory(com.application.warehouseManagement.dto.CategoryDTO))")
	public void createcategoryLoggingEnd() {
		logger.info("Create category method completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.getCategory(String))")
	public void getCategoryStart() {
		logger.info("Get category by category Id method started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.getCategory(String))")
	public void getCategoryEnd() {
		logger.info("Get Category by category Id method completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.getAllCategoriesInGoodown(String))")
	public void getAllCategoriesInGoodownStart() {
		logger.info("getAllCategoriesInGoodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.getAllCategoriesInGoodown(String))")
	public void getAllCategoriesInGoodownEnd() {
		logger.info("getAllCategoriesInGoodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.updateCategory(String, java.util.Map<String, Object>))")
	public void updateCategoryStart() {
		logger.info("updateCategory started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.updateCategory(String, java.util.Map<String, Object>))")
	public void updateCategoryEnd() {
		logger.info("updateCategory completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.deleteCategory(String))")
	public void deleteCategoryStart() {
		logger.info("deleteCategory started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.CategoryServiceImpl.deleteCategory(String))")
	public void deleteCategoryEnd() {
		logger.info("deleteCategory completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.addProductToGoodown(com.application.warehouseManagement.dto.GoodownProductDTO))")
	public void addProductToGoodownStart() {
		logger.info("Add product to goodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.addProductToGoodown(com.application.warehouseManagement.dto.GoodownProductDTO))")
	public void addProductToGoodownEnd() {
		logger.info("Add product to goodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.updateGoodownProduct(String, java.util.Map<String, Object>))")
	public void updateGoodownProduct() {
		logger.info("update goodown product started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.updateGoodownProduct(String, java.util.Map<String, Object>))")
	public void updateGoodownProductEnd() {
		logger.info("update goodown product completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.getGoodownProductById(String))")
	public void getGoodownproductById() {
		logger.info("get product by Id started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.getGoodownProductById(String))")
	public void getGoodownproductByIdEnd() {
		logger.info("get product by Id completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.deleteGoodownProductById(String))")
	public void deleteGoodownProductById() {
		logger.info("Delete product by Id started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.deleteGoodownProductById(String))")
	public void deleteGoodownProductByIdEnd() {
		logger.info("Delete product by Id completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.getAllProductsInCategoryInGoodown(String, String))")
	public void getAllProductsInCategoryInGoodown() {
		logger.info("getAllProductsInCategoryInGoodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownProductsServiceImpl.getAllProductsInCategoryInGoodown(String, String))")
	public void getAllProductsInCategoryInGoodownEnd() {
		logger.info("getAllProductsInCategoryInGoodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.createGoodown(com.application.warehouseManagement.dto.GoodownDTO))")
	public void createGoodownStart() {
		logger.info("create goodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.createGoodown(com.application.warehouseManagement.dto.GoodownDTO))")
	public void createGoodownEnd() {
		logger.info("create goodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.updateGoodownDetails(String, java.util.Map<String, Object>))")
	public void updateGoodownDetails() {
		logger.info("update goodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.updateGoodownDetails(String, java.util.Map<String, Object>))")
	public void updateGoodownDetailsEnd() {
		logger.info("update goodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.getGoodownByGoodownId(String))")
	public void getGoodownByGoodownId() {
		logger.info("get goodown by ID started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.getGoodownByGoodownId(String))")
	public void getGoodownByGoodownIdEnd() {
		logger.info("get goodown by ID completed");
	}
	
	@Before("execution (public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.deleteGoodownByGoodownId(String))")
	public void deleteGoodownById() {
		logger.info("delete goodown by Id started");
	}
	
	@AfterReturning("execution (public * com.application.warehouseManagement.serviceImpl.GoodownServiceImpl.deleteGoodownByGoodownId(String))")
	public void deleteGoodownByIdEnd() {
		logger.info("delete goodown by Id completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.addStoreToGoodown(com.application.warehouseManagement.dto.StoreDTO))")
	public void addStoreToGoodown() {
		logger.info("addStoreToGoodown started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.addStoreToGoodown(com.application.warehouseManagement.dto.StoreDTO))")
	public void addStoreToGoodownEnd() {
		logger.info("addStoreToGoodown completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.updateStoreDetails(int, java.util.Map<String, Object>))")
	public void updateStoreDetails() {
		logger.info("update store details started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.updateStoreDetails(int, java.util.Map<String, Object>))")
	public void updateStoreDetailsEnd() {
		logger.info("update store details completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.getStoreDetailsByStoreId(int))")
	public void getStoreDetailsById() {
		logger.info("get store details by ID started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.getStoreDetailsByStoreId(int))")
	public void getStoreDetailsByIdEnd() {
		logger.info("get store details by ID completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.getStoreDetailsByStoreName(String))")
	public void getStoreDetailsByStoreName() {
		logger.info("get store details by store name started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.serviceImpl.StoreServiceImpl.getStoreDetailsByStoreName(String))")
	public void getStoreDetailsByStoreNameEnd() {
		logger.info("get store details by store name completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.goodownValidator(String))")
	public void goodownValidator() {
		logger.info("Goodown validation started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.goodownValidator(String))")
	public void goodownValidatorEnd() {
		logger.info("Goodown validation completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateStore(int))")
	public void validateStore() {
		logger.info("Store validation started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateStore(int))")
	public void validateStoreEnd() {
		logger.info("Store validation completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateCategory(String))")
	public void validateCategory() {
		logger.info("Category validation started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateCategory(String))")
	public void validateCategoryEnd() {
		logger.info("Category validation completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateProduct(String))")
	public void validateProduct() {
		logger.info("Product validation started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateProduct(String))")
	public void validateProductEnd() {
		logger.info("Product validation completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateUser(String))")
	public void validateUser() {
		logger.info("User validation started");
	}
	
	@AfterReturning("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateUser(String))")
	public void validateUserEnd() {
		logger.info("User validation completed");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateOrder(java.util.UUID))")
	public void validateOrder() {
		logger.info("Order validation started");
	}
	
	@Before("execution(public * com.application.warehouseManagement.util.StoreAndCategoryValidatior.validateOrder(java.util.UUID))")
	public void validateOrderEnd() {
		logger.info("Order validation completed");
	}
	
	

}
