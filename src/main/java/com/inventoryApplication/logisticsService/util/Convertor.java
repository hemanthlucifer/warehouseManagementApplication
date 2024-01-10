package com.inventoryApplication.logisticsService.util;

import org.springframework.stereotype.Component;

import com.inventoryApplication.logisticsService.dto.GoodownDTO;
import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.dto.StoreDTO;
import com.inventoryAppliction.logisticsService.model.Goodown;
import com.inventoryAppliction.logisticsService.model.GoodownProduct;
import com.inventoryAppliction.logisticsService.model.Store;

@Component
public class Convertor {
	
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
		goodownProduct.setProductId(goodownProductDto.getProductId());
		goodownProduct.setActualQuantity(goodownProductDto.getActualQuantity());
		goodownProduct.setAvailableQuantity(goodownProductDto.getAvailableQuantity());
		goodownProduct.setGoodownId(goodownProductDto.getGoodownId());
		goodownProduct.setStorageQuantity(goodownProductDto.getStorageQuantity());
		return goodownProduct;
	}
	
	public GoodownProductDTO convertGoodownProductToDto(GoodownProduct goodownProduct) {
		GoodownProductDTO goodownProductDto = new GoodownProductDTO();
		goodownProductDto.setGoodownId(goodownProduct.getGoodownId());
		goodownProductDto.setProductId(goodownProduct.getProductId());
		goodownProductDto.setActualQuantity(goodownProduct.getActualQuantity());
		goodownProductDto.setAvailableQuantity(goodownProduct.getAvailableQuantity());
		goodownProductDto.setStorageQuantity(goodownProduct.getStorageQuantity());
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
