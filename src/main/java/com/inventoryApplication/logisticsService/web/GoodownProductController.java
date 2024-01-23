package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.GoodownProductDTO;
import com.inventoryApplication.logisticsService.service.GoodownProductService;


@RestController
@RequestMapping("/gProduct")
public class GoodownProductController {
    
	@Autowired
	private GoodownProductService service;
	
	@PostMapping("/")
	public ResponseEntity<GoodownProductDTO> createGoodown(GoodownProductDTO product){
		GoodownProductDTO productDTO = service.addProductToGoodown(product);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<GoodownProductDTO> getProductById(@PathVariable("productId")String productId){
		GoodownProductDTO productDTO = service.getGoodownProductById(productId);
		return new ResponseEntity<>(productDTO,HttpStatus.OK);
	}
	
}
