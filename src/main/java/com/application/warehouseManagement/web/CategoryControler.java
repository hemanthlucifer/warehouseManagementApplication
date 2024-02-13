package com.inventoryApplication.logisticsService.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.CategoryDTO;

import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.service.CategoryService;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/category")
@OpenAPIDefinition(info=@Info(contact=@Contact(name="warehouse website team"),
description="This service handles all the operations regarding the logistics of warehouse",version="1.0"))
public class CategoryControler {
	
	@Autowired
	private CategoryService service;
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;
	
	@Operation(summary="create catgeory")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Category created sucessfully"),
			@ApiResponse(responseCode="500", description="Something went wrong while creating category")
	})
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
		categoryDTO = service.createCategory(categoryDTO);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	
	@Operation(summary="get catgeory by ID")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="Category fetched sucessfully"),
			@ApiResponse(responseCode="404", description="Category not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching category")
	})
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("categoryId")String categoryId){
		CategoryDTO category = service.getCategory(categoryId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	@Operation(summary="get all categories in goodown")
	@ApiResponses(value= {
			@ApiResponse(responseCode="200", description="all categories fetched sucessfully"),
			@ApiResponse(responseCode="404", description="Goodown not found"),
			@ApiResponse(responseCode="500", description="Something went wrong while fetching categories")
	})
	@GetMapping("/{goodownId}")
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesInGoodown(@PathVariable("goodownId") String goodownId) {
		List<CategoryDTO> categories = service.getAllCategoriesInGoodown(goodownId);
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}

}
