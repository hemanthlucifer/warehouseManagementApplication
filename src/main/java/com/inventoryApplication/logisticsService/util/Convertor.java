package com.inventoryApplication.logisticsService.util;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventoryApplication.logisticsService.dto.GoodownDTO;
import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.dto.StoreDTO;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.model.GoodownProduct;
import com.inventoryApplication.logisticsService.model.Store;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.repository.StoreRepository;

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
	
	public GoodownDTO convertGoodownEntityToGoodownDTO(Goodown goodown) {
		logger.info("convertGoodownEntityToGoodownDTO started");
		GoodownDTO goodownDto = new GoodownDTO();
		goodownDto.setGoodownManager(goodown.getGoodownManager());
		goodownDto.setLocation(goodown.getLocation());
		logger.info("convertGoodownEntityToGoodownDTO completed");
		return goodownDto;
	}

}
