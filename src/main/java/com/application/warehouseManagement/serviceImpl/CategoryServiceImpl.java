package com.application.warehouseManagement.serviceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.application.warehouseManagement.dto.CategoryDTO;
import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.service.CategoryService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private Convertor convertor;
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		validator.goodownValidator(categoryDTO.getGoodownId());
		Goodown goodown = goodownRepository.findByGoodownId(categoryDTO.getGoodownId());
		Category category = convertor.convertCategoryDTOToCategory(categoryDTO);
		category.setGoodownId(goodown);
		Category newCategory = categoryRepository.save(category);
		categoryDTO = convertor.convertCategoryEntityToDTO(newCategory);
		return categoryDTO;
	}

	@Override
	public CategoryDTO getCategory(String categoryId) {
		validator.validateCategory(categoryId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		CategoryDTO categoryDTO = convertor.convertCategoryEntityToDTO(category.get());
		return categoryDTO;
	}

	@Override
	public List<CategoryDTO> getAllCategoriesInGoodown(String goodownId) {
		validator.goodownValidator(goodownId);
		List<Category> categories = categoryRepository.findAllByGoodownId(goodownRepository.findByGoodownId(goodownId));
		List<CategoryDTO> categoryDTOList = new ArrayList<>();
		categories.forEach(category->{
			CategoryDTO categoryDTO = convertor.convertCategoryEntityToDTO(category);
			categoryDTOList.add(categoryDTO);
		});
		return categoryDTOList;
	}

	@Override
	public CategoryDTO updateCategory(String categoryId, Map<String, Object> fields) {
		validator.validateCategory(categoryId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		fields.forEach((key,value)->{
			Field field = ReflectionUtils.findField(Category.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, category.get(), value);
		});
		CategoryDTO categoryDTO = convertor.convertCategoryEntityToDTO(category.get());
		return categoryDTO;
	}

	@Override
	public void deleteCategory(String categoryId) {
		validator.validateCategory(categoryId);
		Optional<Category> category = categoryRepository.findById(categoryId);
		categoryRepository.delete(category.get());
	}

}
