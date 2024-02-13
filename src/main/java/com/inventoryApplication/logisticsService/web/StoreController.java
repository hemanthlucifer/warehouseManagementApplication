package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.inventoryApplication.logisticsService.dto.StoreDTO;

import com.inventoryApplication.logisticsService.service.StoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;



@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@Operation(summary="create Strore")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Store created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating store")
	})
	@PostMapping("/")
	public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO store) {
		StoreDTO storeDTO = service.addStoreToGoodown(store);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}
	
	@Operation(summary="fetch store by storeId")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Store fetched sucessfully"),
			@ApiResponse(responseCode="404", description="Store not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching store")
	})
	@GetMapping("/{storeId}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId")int storeId){
		StoreDTO storeDto = service.getStoreDetailsByStoreId(storeId);
		return new ResponseEntity<>(storeDto,HttpStatus.OK);
	}
	
	@Operation(summary="fetch store by store name")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="store fetched sucessfully"),
			@ApiResponse(responseCode="404", description="Store not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching store")
	})
	@GetMapping("/")
	public ResponseEntity<StoreDTO> getStoreByName(@RequestParam("storeName") String storeName){
		StoreDTO storeDTO = service.getStoreDetailsByStoreName(storeName);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}

}
