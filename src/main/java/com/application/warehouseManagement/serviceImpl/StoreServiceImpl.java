package com.application.warehouseManagement.serviceImpl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.warehouseManagement.dto.StoreDTO;
import com.application.warehouseManagement.model.Store;
import com.application.warehouseManagement.repository.StoreRepository;
import com.application.warehouseManagement.service.StoreService;
import com.application.warehouseManagement.util.Convertor;
import com.application.warehouseManagement.util.StoreAndCategoryValidatior;

import org.springframework.util.ReflectionUtils;
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private Convertor convertor;
	
	@Autowired
	private StoreAndCategoryValidatior validator;

	@Override
	public StoreDTO addStoreToGoodown(StoreDTO storeDTO) {
		Store store = convertor.convertStoreDtoToEntity(storeDTO);
		store = storeRepository.save(store);
		storeDTO = convertor.convertStoreEntityToStoreDTO(store);
		return storeDTO;
		
	}

	@Override
	public StoreDTO updateStoreDetails(int storeId, Map<String, Object> fields) {
		validator.validateStore(storeId);
		Optional<Store> store = storeRepository.findById(storeId);
			fields.forEach((key,value)->{
				Field field = ReflectionUtils.findField(Store.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, store.get(), value);
			});
			StoreDTO storeDto = convertor.convertStoreEntityToStoreDTO(store.get());
			return storeDto;
		
	}

	@Override
	public StoreDTO getStoreDetailsByStoreId(int storeId) {
		validator.validateStore(storeId);
		Optional<Store> store = storeRepository.findById(storeId);  
		StoreDTO storeDto = convertor.convertStoreEntityToStoreDTO(store.get());
		return storeDto;
		
	}

	@Override
	public StoreDTO getStoreDetailsByStoreName(String storeName) {
		Store store = storeRepository.findByStoreName(storeName);
		if(store==null) {
			return null;
		}else {
			StoreDTO storeDto = convertor.convertStoreEntityToStoreDTO(store);
			return storeDto;
		}
	}

}
