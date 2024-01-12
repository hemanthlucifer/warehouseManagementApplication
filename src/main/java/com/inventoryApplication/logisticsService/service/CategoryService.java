package com.inventoryApplication.logisticsService.service;

import java.util.List;
import java.util.Map;

import com.inventoryApplication.logisticsService.model.Category;

public interface CategoryService {
	
	public Category createCategory(Category category);
	public Category getCategory(String categoryId);
	public List<Category> getAllCategoriesInGoodown(String goodownId);
	public Category updateCategory(String categoryId,Map<String,Object> fields);
	public void deleteCategory(String categroyId);

}
