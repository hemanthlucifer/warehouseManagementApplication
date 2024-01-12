package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.service.CategoryService;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;

	@Override
	public Category createCategory(Category category) {
		validator.goodownValidator(category.getGoodownId().getGoodownId());
		category = categoryRepository.save(category);
		return category;
	}

	@Override
	public Category getCategory(String categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			
		}
		return category.get();
	}

	@Override
	public List<Category> getAllCategoriesInGoodown(String goodownId) {
		List<Category> catgeory = categoryRepository.findAllByGoodownId(goodownId);
		return catgeory;
	}

	@Override
	public Category updateCategory(String categoryId, Map<String, Object> fields) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			return null;	
		}
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(Category.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, category.get(), value);
		});
		return category.get();
	}

	@Override
	public void deleteCategory(String categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			
		}
		categoryRepository.delete(category.get());
	}

}
