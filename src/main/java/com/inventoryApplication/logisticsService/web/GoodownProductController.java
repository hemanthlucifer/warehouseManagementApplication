package com.inventoryApplication.logisticsService.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.service.GoodownProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@SwaggerDefinition(info=@Info(title = "Goodown Product Controller", version = "v1.0",
description="Goodown product controller used to perfom CRUD operations on goodown product"))
@Api(value="Goodown Product Controller",tags="Goodown")
@RestController
@RequestMapping("/gProduct")
public class GoodownProductController {
    
	@Autowired
	private GoodownProductService service;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Goodown Product created sucessfully",response=GoodownProductDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Goodown Product creation",notes="This API is used for creating the goodown product",nickname="Create goodown product")
	@PostMapping("/")
	public ResponseEntity<GoodownProductDTO> createGoodown(@RequestBody GoodownProductDTO product){
		GoodownProductDTO productDTO = service.addProductToGoodown(product);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Goodown Product fetched sucessfully",response=GoodownProductDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=404,message="Goodown product not found"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Goodown Product fetching",notes="This API is used for fetching the goodown product",nickname="Create goodown product")
	@GetMapping("/{productId}")
	public ResponseEntity<GoodownProductDTO> getProductById(@PathVariable("productId")String productId){
		GoodownProductDTO productDTO = service.getGoodownProductById(productId);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Goodown Product fetched sucessfully",response=GoodownProductDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=404,message="Goodown product not found"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Goodown Product fetching",notes="This API is used for fetching the goodown product based on goodown and category",nickname="fetch goodown product")
	@GetMapping("/goodownCategory/{goodownId}/{categoryId}")
	public ResponseEntity<List<GoodownProductDTO>> getAllProductsInCategoryInGoodown(@PathVariable String goodownId, @PathVariable String categoryId){
		List<GoodownProductDTO> goodownProductDto = service.getAllProductsInCategoryInGoodown(goodownId, categoryId);
		return new ResponseEntity<>(goodownProductDto,HttpStatus.OK);
	}
	
}
