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

@RestController
@RequestMapping("/categoory")
public class CategoryControler {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(Category category){
		Category categoryDTO = service.createCategory(category);
		return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("categoryId")String categoryId){
		Category category = service.getCategory(categoryId);
		return new ResponseEntity<>(category,HttpStatus.OK);
	}

}
