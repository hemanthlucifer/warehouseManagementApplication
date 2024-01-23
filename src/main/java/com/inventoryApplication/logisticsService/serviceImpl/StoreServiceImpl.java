package com.inventoryApplication.logisticsService.serviceImpl;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventoryApplication.logisticsService.dto.StoreDTO;
import com.inventoryApplication.logisticsService.model.Store;
import com.inventoryApplication.logisticsService.repository.StoreRepository;
import com.inventoryApplication.logisticsService.service.StoreService;
import com.inventoryApplication.logisticsService.util.Convertor;

import org.springframework.util.ReflectionUtils;
@Service
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private Convertor convertor;

	@Override
	public StoreDTO addStoreToGoodown(StoreDTO storeDTO) {
		
		Store store = convertor.convertStoreDtoToEntity(storeDTO);
		store = storeRepository.save(store);
		storeDTO = convertor.convertStoreEntityToStoreDTO(store);
		return storeDTO;
		
	}

	@Override
	public StoreDTO updateStoreDetails(int storeId, Map<String, Object> fields) {
		Optional<Store> store = storeRepository.findById(storeId);
		if(store.isEmpty()||store==null) {
			return null;
		}else {
			fields.forEach((key,value)->{
				Field field = ReflectionUtils.findField(Store.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, store.get(), value);
			});
			StoreDTO storeDto = convertor.convertStoreEntityToStoreDTO(store.get());
			return storeDto;
		}
	}

	@Override
	public StoreDTO getStoreDetailsByStoreId(int storeId) {
		Optional<Store> store = storeRepository.findById(storeId);
		if(store.isEmpty() || store==null) {
			return null;
		}else {
		   StoreDTO storeDto = convertor.convertStoreEntityToStoreDTO(store.get());
		   return storeDto;
		}
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
