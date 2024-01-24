package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;

@RestController
@RequestMapping("/category")
@SwaggerDefinition(info=@Info(title="Category Controller", version = "v1.0",description="This is used for perfoming CRUD operations for goodown category"))
@Api(value="Logistics service category controller", tags="Category Controller")
public class CategoryControler {
	
	@Autowired
	private CategoryService service;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Category created sucessfully",response=Category.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Category creation",notes="This API is used for creating the category",nickname="Create Category")
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(Category category){
		Category categoryDTO = service.createCategory(category);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Category fetched sucessfully",response=Category.class),
			@ApiResponse(code=404,message="category not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Category fetching",notes="This API is used for fetching the category",nickname="get Category")
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId")String categoryId){
		Category category = service.getCategory(categoryId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}

}
