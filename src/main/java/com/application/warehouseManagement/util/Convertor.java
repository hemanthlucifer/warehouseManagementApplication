package com.application.warehouseManagement.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.warehouseManagement.dto.CategoryDTO;
import com.application.warehouseManagement.dto.GetGoodownDTO;
import com.application.warehouseManagement.dto.GoodownDTO;
import com.application.warehouseManagement.dto.GoodownProductDTO;
import com.application.warehouseManagement.dto.StoreDTO;
import com.application.warehouseManagement.model.Category;
import com.application.warehouseManagement.model.Goodown;
import com.application.warehouseManagement.model.GoodownProduct;
import com.application.warehouseManagement.model.Store;
import com.application.warehouseManagement.repository.CategoryRepository;
import com.application.warehouseManagement.repository.GoodownRepository;
import com.application.warehouseManagement.repository.StoreRepository;

@Component
public class Convertor {
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(Convertor.class);
	
	public Store convertStoreDtoToEntity(StoreDTO storeDto) {
		logger.info("convertStoreDtoToEntity started");
		Store store = new Store();
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		logger.info("convertStoreDtoToEntity completed");
		return store;
	}
	
	public StoreDTO convertStoreEntityToStoreDTO(Store store) {
		logger.info("convertStoreEntityToStoreDTO started");
		StoreDTO storeDto = new StoreDTO();
		storeDto.setNoOfOrderForStore(store.getNoOfOrderForStore());
		storeDto.setStoreLocation(store.getStoreLocation());
		storeDto.setStoreName(store.getStoreName());
		logger.info("convertStoreEntityToStoreDTO completed");
		return storeDto;
	}
	
	public GoodownProduct convertGProductDtoToEntity(GoodownProductDTO goodownProductDto) {
		logger.info("convertGProductDtoToEntity started");
		GoodownProduct goodownProduct = new GoodownProduct();
		Goodown goodown = goodownRepository.findByGoodownId(goodownProductDto.getGoodownId());
		Optional<Category> category = categoryRepository.findById(goodownProductDto.getCategoryId());
		Optional<Store> store = storeRepository.findById(goodownProductDto.getStoreId());
		goodownProduct.setProductId(goodownProductDto.getProductId());
		goodownProduct.setGoodownId(goodown);
		goodownProduct.setCategoryId(category.get());
		goodownProduct.setQuantity(goodownProductDto.getQuantity());
		goodownProduct.setStoreId(store.get());
		goodownProduct.setProductManufacturer(goodownProductDto.getProductManufacturer());
		goodownProduct.setProductDescription(goodownProductDto.getProductDescription());
		goodownProduct.setProductVersion(goodownProductDto.getProductVersion());
		logger.info("convertGProductDtoToEntity completed");
		return goodownProduct;
	}
	
	public GoodownProductDTO convertGoodownProductToDto(GoodownProduct goodownProduct) {
		logger.info("convertGoodownProductToDto started");
		GoodownProductDTO goodownProductDto = new GoodownProductDTO();
		goodownProductDto.setGoodownId(goodownProduct.getGoodownId().getGoodownId());
		goodownProductDto.setProductId(goodownProduct.getProductId());
		goodownProductDto.setCategoryId(goodownProduct.getCategoryId().getCategoryId());
		goodownProductDto.setQuantity(goodownProduct.getQuantity());
		goodownProductDto.setStoreId(goodownProduct.getStoreId().getStoreId());
		goodownProductDto.setProductDescription(goodownProduct.getProductDescription());
		goodownProductDto.setProductManufacturer(goodownProduct.getProductManufacturer());
		goodownProductDto.setProductVersion(goodownProduct.getProductVersion());
		logger.info("convertGoodownProductToDto completed");
		return goodownProductDto;
	}
	
	public Goodown convertGoodownDtoToEntity(GoodownDTO goodownDto) {
		logger.info("convertGoodownDtoToEntity started");
		Goodown goodown = new Goodown();
		goodown.setGoodownManager(goodownDto.getGoodownManager());
		goodown.setLocation(goodownDto.getLocation());
		logger.info("convertGoodownDtoToEntity completed");
		return goodown;
	}
	
	public GetGoodownDTO convertGoodownEntityToGoodownDTO(Goodown goodown) {
		logger.info("convertGoodownEntityToGoodownDTO started");
		GetGoodownDTO goodownDto = new GetGoodownDTO();
		goodownDto.setGoodownManager(goodown.getGoodownManager());
		goodownDto.setLocation(goodown.getLocation());
		goodownDto.setGoodownId(goodown.getGoodownId());
		logger.info("convertGoodownEntityToGoodownDTO completed");
		return goodownDto;
	}
	
	public CategoryDTO convertCategoryEntityToDTO(Category category) {
		logger.info("convertCategoryEntityToDTO started");
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCategoryId());
		categoryDTO.setAvailableCapacity(category.getAvailableCapacity());
		categoryDTO.setGoodownCapacity(category.getGoodownCapacity());
		categoryDTO.setGoodownId(category.getGoodownId().getGoodownId());
		categoryDTO.setOccupiedCapacity(category.getOccupiedCapacity());
		logger.info("convertCategoryEntityToDTO completed");
		return categoryDTO;
	}
	
	public Category convertCategoryDTOToCategory(CategoryDTO categoryDTO) {
		logger.info("convertCategotyToCategoryDTO started");
		Category category = new Category();
		category.setAvailableCapacity(categoryDTO.getAvailableCapacity());
		category.setCategoryId(categoryDTO.getCategoryId());
		category.setGoodownCapacity(categoryDTO.getGoodownCapacity());
		/** will set goodownID in service class */
		category.setOccupiedCapacity(categoryDTO.getOccupiedCapacity());
		logger.info("convertCategotyToCategoryDTO completed");
		return category;
	}

}
