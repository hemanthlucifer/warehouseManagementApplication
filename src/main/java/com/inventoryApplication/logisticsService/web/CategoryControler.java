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
import com.inventoryApplication.logisticsService.model.Category;
import com.inventoryApplication.logisticsService.model.Goodown;
import com.inventoryApplication.logisticsService.repository.CategoryRepository;
import com.inventoryApplication.logisticsService.repository.GoodownRepository;
import com.inventoryApplication.logisticsService.service.CategoryService;
import com.inventoryApplication.logisticsService.util.StoreAndCategoryValidatior;

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
	
	@Autowired
	private GoodownRepository goodownRepository;
	
	@Autowired
	private StoreAndCategoryValidatior validator;
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Category created sucessfully",response=CategoryDTO.class),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Category creation",notes="This API is used for creating the category",nickname="Create Category")
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
		categoryDTO = service.createCategory(categoryDTO);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Category fetched sucessfully",response=CategoryDTO.class),
			@ApiResponse(code=404,message="category not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Category fetching",notes="This API is used for fetching the category",nickname="get Category")
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("categoryId")String categoryId){
		CategoryDTO category = service.getCategory(categoryId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}
	
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Categories fetched sucessfully",response=CategoryDTO.class),
			@ApiResponse(code=404,message="Goodown not found with the given Id"),
			@ApiResponse(code=500,message="Something went wrong")
	})
	@ApiOperation(value="Category fetching",notes="This API is used for fetching all categories in a goodown",nickname="get Category")
	@GetMapping("/{goodownId}")
	public ResponseEntity<List<CategoryDTO>> getAllCategoriesInGoodown(@PathVariable("goodownId") String goodownId) {
		List<CategoryDTO> categories = service.getAllCategoriesInGoodown(goodownId);
		return new ResponseEntity<>(categories,HttpStatus.OK);
	}

}
