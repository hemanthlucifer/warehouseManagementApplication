package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.StoreDTO;
import com.inventoryApplication.logisticsService.service.StoreService;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@PostMapping("/")
	public ResponseEntity<StoreDTO> createStore(StoreDTO store) {
		StoreDTO storeDTO = service.addStoreToGoodown(store);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{storeId}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId")int storeId){
		StoreDTO storeDto = service.getStoreDetailsByStoreId(storeId);
		return new ResponseEntity<>(storeDto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<StoreDTO> getStoreByName(@RequestParam("storeName") String storeName){
		StoreDTO storeDTO = service.getStoreDetailsByStoreName(storeName);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}

}
