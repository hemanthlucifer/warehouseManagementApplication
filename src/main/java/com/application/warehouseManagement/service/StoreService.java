package com.application.warehouseManagement.service;

import java.util.Map;

import com.application.warehouseManagement.dto.StoreDTO;

public interface StoreService {
	
	public StoreDTO addStoreToGoodown(StoreDTO storeDTO);
	public StoreDTO updateStoreDetails(int storeId, Map<String,Object> fields);
	public StoreDTO getStoreDetailsByStoreId(int storeId);
	public StoreDTO getStoreDetailsByStoreName(String storeName);

}
