package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.service.CategoryService;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Override
	public Category createCategory(Category category) {
		logger.info("Create category method started");
		validator.goodownValidator(category.getGoodownId().getGoodownId());
		category = categoryRepository.save(category);
		logger.info("Category has been saved to repository");
		logger.info("Create Category method is completed");
		return category;
	}

	@Override
	public Category getCategory(String categoryId) {
		logger.info("Get category by category Id method started");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			logger.warn("No category found with the given category Id");
		}
		logger.info("Get Category by category Id method completed");
		return category.get();
	}

	@Override
	public List<Category> getAllCategoriesInGoodown(String goodownId) {
		logger.info("getAllCategoriesInGoodown started");
		validator.goodownValidator(goodownId);
		List<Category> catgeory = categoryRepository.findAllByGoodownId(goodownRepository.findByGoodownId(goodownId));
		logger.info("getAllCategoriesInGoodown completed");
		return catgeory;
	}

	@Override
	public Category updateCategory(String categoryId, Map<String, Object> fields) {
		logger.info("updateCategory started");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			logger.warn("No categories found with the given category Id");
			return null;	
		}
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(Category.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, category.get(), value);
		});
		logger.info("updateCategory completed");
		return category.get();
	}

	@Override
	public void deleteCategory(String categoryId) {
		logger.info("deleteCategory started");
		Optional<Category> category = categoryRepository.findById(categoryId);
		if(category.isEmpty()||category==null) {
			logger.warn("No category found with the given category Id");
		}
		categoryRepository.delete(category.get());
		logger.info("deleteCategory completed");
	}

}
