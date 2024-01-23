package com.inventoryApplication.logisticsService.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventoryApplication.logisticsService.dto.GoodownDTO;
import com.inventoryApplication.logisticsService.service.GoodownService;


@RestController
@RequestMapping("/goodown")
public class GoodownController {
	
	@Autowired
	private GoodownService service;
	
	@PostMapping("/")
	public ResponseEntity<GoodownDTO> createGoodown(GoodownDTO goodown) {
		GoodownDTO goodownDTO = service.createGoodown(goodown);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	@GetMapping("/{goodownId}")
	public ResponseEntity<GoodownDTO> getGoodownById(@PathVariable("goodownId")String goodownId){
		GoodownDTO goodownDTO = service.getGoodownByGoodownId(goodownId);
		return new ResponseEntity<>(goodownDTO,HttpStatus.OK);
	}
	
	

}
