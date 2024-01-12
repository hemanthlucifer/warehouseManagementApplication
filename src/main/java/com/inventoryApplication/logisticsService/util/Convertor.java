package com.inventoryApplication.logisticsService.util;

import java.util.Optional;

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

@Component
public class Convertor {
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Store convertStoreDtoToEntity(StoreDTO storeDto) {
		Store store = new Store();
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		return store;
	}
	
	public StoreDTO convertStoreEntityToStoreDTO(Store store) {
		StoreDTO storeDto = new StoreDTO();
		storeDto.setNoOfOrderForStore(store.getNoOfOrderForStore());
		storeDto.setStoreLocation(store.getStoreLocation());
		storeDto.setStoreName(store.getStoreName());
		return storeDto;
	}
	
	public GoodownProduct convertGProductDtoToEntity(GoodownProductDTO goodownProductDto) {
		GoodownProduct goodownProduct = new GoodownProduct();
		Goodown goodown = goodownRepository.findByGoodownId(goodownProductDto.getGoodownId());
		Optional<Category> category = categoryRepository.findById(goodownProductDto.getCategoryId());
		goodownProduct.setProductId(goodownProductDto.getProductId());
		goodownProduct.setGoodownId(goodown);
		goodownProduct.setCategoryId(category.get());
		goodownProduct.setQuantity(goodownProductDto.getQuantity());
		goodownProduct.setStoreId(goodownProductDto.getStoreId());
		return goodownProduct;
	}
	
	public GoodownProductDTO convertGoodownProductToDto(GoodownProduct goodownProduct) {
		GoodownProductDTO goodownProductDto = new GoodownProductDTO();
		goodownProductDto.setGoodownId(goodownProduct.getGoodownId().getGoodownId());
		goodownProductDto.setProductId(goodownProduct.getProductId());
		goodownProductDto.setCategoryId(goodownProduct.getCategoryId().getCategoryId());
		goodownProductDto.setQuantity(goodownProduct.getQuantity());
		goodownProductDto.setStoreId(goodownProduct.getStoreId());
		return goodownProductDto;
	}
	
	public Goodown convertGoodownDtoToEntity(GoodownDTO goodownDto) {
		Goodown goodown = new Goodown();
		goodown.setGoodownManager(goodownDto.getGoodownManager());
		goodown.setLocation(goodownDto.getLocation());
		return goodown;
	}
	
	public GoodownDTO convertGoodownEntityToGoodownDTO(Goodown goodown) {
		GoodownDTO goodownDto = new GoodownDTO();
		goodownDto.setGoodownManager(goodown.getGoodownManager());
		goodownDto.setLocation(goodown.getLocation());
		return goodownDto;
	}

}
