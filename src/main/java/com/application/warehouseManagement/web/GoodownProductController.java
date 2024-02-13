package com.application.warehouseManagement.web;

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

import com.application.warehouseManagement.dto.GoodownProductDTO;
import com.application.warehouseManagement.service.GoodownProductService;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/gProduct")
public class GoodownProductController {
    
	@Autowired
	private GoodownProductService service;
	
	@Operation(summary="create GoodownProduct")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="GoodownProduct created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating GoodownProduct")
	})
	@PostMapping("/")
	public ResponseEntity<GoodownProductDTO> createGoodown(@RequestBody GoodownProductDTO product){
		GoodownProductDTO productDTO = service.addProductToGoodown(product);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@Operation(summary="fetch GoodownProduct by productId")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="GoodownProduct fetched sucessfully"),
			@ApiResponse(responseCode="404", description="GoodownProduct not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching GoodownProduct")
	})
	@GetMapping("/{productId}")
	public ResponseEntity<GoodownProductDTO> getProductById(@PathVariable("productId")String productId){
		GoodownProductDTO productDTO = service.getGoodownProductById(productId);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@Operation(summary="fetch all GoodownProducts in a category of goodown")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="GoodownProducts fetched sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching GoodownProducts")
	})
	@GetMapping("/goodownCategory/{goodownId}/{categoryId}")
	public ResponseEntity<List<GoodownProductDTO>> getAllProductsInCategoryInGoodown(@PathVariable String goodownId, @PathVariable String categoryId){
		List<GoodownProductDTO> goodownProductDto = service.getAllProductsInCategoryInGoodown(goodownId, categoryId);
		return new ResponseEntity<>(goodownProductDto,HttpStatus.OK);
	}
	
}
