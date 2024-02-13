package com.application.warehouseManagement.service;

import java.util.List;
import java.util.Map;

import com.application.warehouseManagement.dto.CategoryDTO;
import com.application.warehouseManagement.model.Category;

public interface CategoryService {
	
	public CategoryDTO createCategory(CategoryDTO categoryDTO);
	public CategoryDTO getCategory(String categoryId);
	public List<CategoryDTO> getAllCategoriesInGoodown(String goodownId);
	public CategoryDTO updateCategory(String categoryId,Map<String,Object> fields);
	public void deleteCategory(String categroyId);

}
