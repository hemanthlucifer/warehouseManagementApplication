package com.inventoryApplication.logisticsService.service;

import java.util.List;
import java.util.Map;

import com.inventoryApplication.logisticsService.dto.CategoryDTO;
import com.inventoryApplication.logisticsService.model.Category;

public interface CategoryService {
	
	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	public CategoryDTO getCategory(String categoryId);
	public List<CategoryDTO> getAllCategoriesInGoodown(String goodownId);
	public CategoryDTO updateCategory(String categoryId,Map<String,Object> fields);
	public void deleteCategory(String categroyId);

}
