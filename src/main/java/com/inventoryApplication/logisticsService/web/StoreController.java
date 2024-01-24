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

import com.inventoryApplication.logisticsService.dto.GetQuoteDTO;
import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.dto.StoreDTO;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info=@Info(title = "Store Controller", version = "v1.0",
description="This contoller is used for perfoming CRUD operations on the store"))
@Api(value="Store Controller",tags ="Store")
@RestController
@RequestMapping("/store")
public class StoreController {
	
	@Autowired
	private StoreService service;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Store created sucessfully",response=StoreDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Store creation",notes="This API is used for creating the store product",nickname="Create goodown product")
	@PostMapping("/")
	public ResponseEntity<StoreDTO> createStore(StoreDTO store) {
		StoreDTO storeDTO = service.addStoreToGoodown(store);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Store fetched sucessfully",response=StoreDTO.class),
			@ApiResponse(code=404,message="store not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Store creation",notes="This API is used for fetching the store with store Id",nickname="get store by id")
	@GetMapping("/{storeId}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable("storeId")int storeId){
		StoreDTO storeDto = service.getStoreDetailsByStoreId(storeId);
		return new ResponseEntity<>(storeDto,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Store fetched sucessfully",response=StoreDTO.class),
			@ApiResponse(code=404,message="store not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Store fetching",notes="This API is used for fetching the store with store name",nickname="get store by name")
	@GetMapping("/")
	public ResponseEntity<StoreDTO> getStoreByName(@RequestParam("storeName") String storeName){
		StoreDTO storeDTO = service.getStoreDetailsByStoreName(storeName);
		return new ResponseEntity<>(storeDTO,HttpStatus.OK);
	}

}
